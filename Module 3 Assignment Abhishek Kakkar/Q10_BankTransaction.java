class BankTransaction extends Thread {
    private String transactionName;
    private double amount;

    public BankTransaction(String transactionName, double amount) {
        this.transactionName = transactionName;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println(transactionName + " processed: ₹" + amount);
    }
}

public class Q10_BankTransaction {
    public static void main(String[] args) throws InterruptedException {
        BankTransaction lowValue =
                new BankTransaction("Low-value transaction", 5000);

        BankTransaction highValue =
                new BankTransaction("High-value transaction", 50000);

        highValue.setPriority(Thread.MAX_PRIORITY);
        lowValue.setPriority(Thread.MIN_PRIORITY);

        // Priority is a scheduling hint in Java, so the high-value
        // transaction is explicitly completed first for the required output.
        highValue.start();
        highValue.join();

        System.out.println("High-value transaction processed first");

        lowValue.start();
        lowValue.join();

        System.out.println("Low-value transaction processed later");
    }
}
