package hackerrank.PracticeJava.JavaExceptionHandlingTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println(x / y);

        } catch (InputMismatchException e) {
            System.out.print(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.print(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

