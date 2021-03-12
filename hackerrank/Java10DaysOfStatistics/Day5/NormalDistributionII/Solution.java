package hackerrank.Java10DaysOfStatistics.Day5.NormalDistributionII;

import java.util.Scanner;


public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mean = scanner.nextInt();
        int deviation = scanner.nextInt();
        double number = scanner.nextDouble();
        int pass = scanner.nextInt();

        System.out.printf("%.2f\n", findNormalDistribution(pass, mean, deviation) * 100);
        System.out.printf("%.2f\n", findNormalDistribution(number, mean, deviation) * 100);
        System.out.printf("%.2f\n", (1 - findNormalDistribution(number, mean, deviation)) * 100);
    }

    private static double findNormalDistribution(double number, int mean, int deviation) {
        return 0.5 * (1 + erf((number - mean) / (deviation * Math.sqrt(2))));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 +
                t * (1.00002368 +
                        t * (0.37409196 +
                                t * (0.09678418 +
                                        t * (-0.18628806 +
                                                t * (0.27886807 +
                                                        t * (-1.13520398 +
                                                                t * (1.48851587 +
                                                                        t * (-0.82215223 +
                                                                                t * (0.17087277))))))))));
        if (z >= 0) return ans;
        else return -ans;
    }

}