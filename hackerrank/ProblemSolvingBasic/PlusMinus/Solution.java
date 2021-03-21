package hackerrank.ProblemSolvingBasic.PlusMinus;

import java.util.Scanner;

public class Solution {

    static void plusMinus(int[] arr) {
        int counterPositive = 0;
        int counterNegative = 0;
        double n = arr.length;

        for (int a : arr) {
            if (a > 0) counterPositive++;
            else if (a < 0) counterNegative++;
        }

        System.out.printf("%.6f\n", (counterPositive / n));
        System.out.printf("%.6f\n", (counterNegative / n));
        System.out.printf("%.6f\n", ((n - counterPositive - counterNegative) / n));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}