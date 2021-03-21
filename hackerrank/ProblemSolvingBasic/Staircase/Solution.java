package hackerrank.ProblemSolvingBasic.Staircase;

import java.util.Scanner;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
        String st = "";
        for (int i = 0; i < n; i++) {
            st += " ";
        }
        StringBuilder result = new StringBuilder(st);
        for (int i = 0; i < n; i++) {
            result.setCharAt(n - i - 1, '#');
            System.out.println(result);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
