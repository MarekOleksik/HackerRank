package hackerrank.Java10DaysOfStatistics.Day4.GeometricDistributionII;

import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double numerator = scanner.nextInt();
        double denominator = scanner.nextInt();
        int inspection = scanner.nextInt();

        double probability = numerator / denominator;
        double result = 0;

        for (int i = 1; i <= inspection; i++) {
            result += Math.pow(1 - probability, i - 1) * probability;
        }

        System.out.printf("%.3f\n", result);
    }
}
