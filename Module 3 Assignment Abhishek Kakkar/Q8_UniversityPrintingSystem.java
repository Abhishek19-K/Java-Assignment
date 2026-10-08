import java.util.Scanner;

class PrinterJob implements Runnable {
    private int jobNumber;
    private String studentName;

    public PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("Printing job " + jobNumber + " by " + studentName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Q8_UniversityPrintingSystem {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int jobs = sc.nextInt();

        Thread[] threads = new Thread[jobs];

        for (int i = 0; i < jobs; i++) {
            String student = "Student " + (char)('A' + i);
            threads[i] = new Thread(new PrinterJob(i + 1, student));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        sc.close();
    }
}
