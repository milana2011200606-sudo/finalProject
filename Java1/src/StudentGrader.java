
import java.util.Scanner;

public class StudentGrader {

    public static String calculateGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student score (0-100): ");
        int score = input.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("Invalid score! Enter a number between 0 and 100.");
        } else {
            System.out.println("Student Grade: " + calculateGrade(score));
        }

        input.close();
    }
}
