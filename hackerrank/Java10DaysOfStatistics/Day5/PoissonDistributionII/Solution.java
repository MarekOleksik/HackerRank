package hackerrank.Java10DaysOfStatistics.Day5.PoissonDistributionII;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        System.out.printf("%.3f\n", 160 + 40 * (x + x * x));
        System.out.printf("%.3f\n", 128 + 40 * (y + y * y));
    }
}