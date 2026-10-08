public class Q4_Loops {
    public static void main(String[] args) {
        System.out.println("First 10 natural numbers using for loop:");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nFirst 10 natural numbers using while loop:");
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }

        System.out.println("\n\nFirst 10 natural numbers using do-while loop:");
        i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= 10);

        System.out.println();
    }
}
