import java.awt.*;
import java.awt.event.*;

public class Q6_StudentRegistrationAWT extends Frame implements ActionListener {
    private TextField nameField;
    private TextField rollField;
    private TextField courseField;
    private Button submitButton;

    public Q6_StudentRegistrationAWT() {
        setTitle("Student Registration Form");
        setLayout(new FlowLayout());

        add(new Label("Name:"));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Roll No:"));
        rollField = new TextField(20);
        add(rollField);

        add(new Label("Course:"));
        courseField = new TextField(20);
        add(courseField);

        submitButton = new Button("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        setSize(350, 220);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "Student registered successfully!\n"
                + "Name: " + nameField.getText() + "\n"
                + "Roll No: " + rollField.getText() + "\n"
                + "Course: " + courseField.getText();

        Dialog dialog = new Dialog(this, "Registration Details", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label("<html>" + message.replace("\n", "<br>") + "</html>"));

        Button ok = new Button("OK");
        ok.addActionListener(event -> dialog.dispose());
        dialog.add(ok);

        dialog.setSize(350, 180);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new Q6_StudentRegistrationAWT();
    }
}
