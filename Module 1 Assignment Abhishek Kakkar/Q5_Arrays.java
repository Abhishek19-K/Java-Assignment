public class Q5_Arrays {
    public static void main(String[] args) {
        // One-dimensional array
        int[] numbers = {10, 25, 7, 40, 18};
        int largest = numbers[0];

        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            }
        }

        System.out.println("One-dimensional array:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\nLargest element: " + largest);

        // Two-dimensional array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("\nTwo-dimensional array:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
