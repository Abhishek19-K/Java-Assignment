import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.*;

public class EmployeeManagement extends JFrame {

    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField departmentField = new JTextField();
    private final JTextField salaryField = new JTextField();

    private final DefaultTableModel model = new DefaultTableModel(
            new String[]{"Employee ID", "Name", "Department", "Salary"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable employeeTable = new JTable(model);

    // Update these values for your local MySQL installation.
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/company_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "YOUR_PASSWORD";

    public EmployeeManagement() {
        setTitle("Employee Management System");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 8, 8));
        form.add(new JLabel("Employee ID:"));
        form.add(idField);
        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("Department:"));
        form.add(departmentField);
        form.add(new JLabel("Salary:"));
        form.add(salaryField);

        JButton submitButton = new JButton("Submit");
        JButton viewButton = new JButton("View All Employees");
        form.add(submitButton);
        form.add(viewButton);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(employeeTable), BorderLayout.CENTER);

        submitButton.addActionListener(e -> addEmployee());
        viewButton.addActionListener(e -> viewEmployees());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private void addEmployee() {
        String sql = "INSERT INTO employees "
                + "(emp_id, name, department, salary) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            int employeeId = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            String department = departmentField.getText().trim();
            BigDecimal salary = new BigDecimal(salaryField.getText().trim());

            if (name.isEmpty() || department.isEmpty() || salary.signum() < 0) {
                JOptionPane.showMessageDialog(this,
                        "Enter valid employee details.");
                return;
            }

            statement.setInt(1, employeeId);
            statement.setString(2, name);
            statement.setString(3, department);
            statement.setBigDecimal(4, salary);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(this,
                    "Employee Added Successfully!");
            clearFields();
            viewEmployees();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Employee ID must be an integer and salary must be numeric.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database error: " + ex.getMessage());
        }
    }

    private void viewEmployees() {
        String sql = "SELECT emp_id, name, department, salary "
                + "FROM employees ORDER BY emp_id";

        model.setRowCount(0);

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                model.addRow(new Object[]{
                    result.getInt("emp_id"),
                    result.getString("name"),
                    result.getString("department"),
                    result.getBigDecimal("salary")
                });
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        departmentField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeManagement::new);
    }
}
