package hackerrank.Java10DaysOfStatistics.Day4.BinomialDistributionII;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double n = scanner.nextDouble() / 100;
        int q = scanner.nextInt();

        double probability = 0;
        for (int i = 0; i <= 2; i++) {
            probability += calculateCombination(i, q) * Math.pow(n, i) * Math.pow(1 - n, q - i);
        }

        System.out.printf("%.3f\n", probability);
        probability = 0;

        for (int i = 2; i <= q; i++) {
            probability += calculateCombination(i, q) * Math.pow(n, i) * Math.pow(1 - n, q - i);
        }

        System.out.printf("%.3f\n", probability);
    }

    private static long calculateCombination(int x, int n) {
        return factorial(n) / (factorial(x) * factorial(n - x));
    }

    private static long factorial(int n) {
        int result = 1;
        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        return result;
    }
}
