
import java.util.Scanner;

public class NumberPatternGenerator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size of the pattern: ");
        int size = input.nextInt();

        if (size <= 0) {
            System.out.println("Invalid size! Please enter a positive number.");
        } else {

            System.out.println("\nChoose pattern type:");
            System.out.println("1 - Right Triangle");
            System.out.println("2 - Inverted Right Triangle");
            System.out.println("3 - Pyramid");
            System.out.println("4 - Inverted Pyramid");
            System.out.println("5 - Number Triangle");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    // Right Triangle
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    // Inverted Right Triangle
                    for (int i = size; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    // Pyramid
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= size - i; j++) {
                            System.out.print(" ");
                        }

                        for (int j = 1; j <= 2 * i - 1; j++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }
                    break;

                case 4:
                    // Inverted Pyramid
                    for (int i = size; i >= 1; i--) {
                        for (int j = 1; j <= size - i; j++) {
                            System.out.print(" ");
                        }

                        for (int j = 1; j <= 2 * i - 1; j++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }
                    break;

                case 5:
                    // Number Triangle
                    for (int i = 1; i <= size; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print(j + " ");
                        }
                        System.out.println();
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }

        input.close();
    }
}
