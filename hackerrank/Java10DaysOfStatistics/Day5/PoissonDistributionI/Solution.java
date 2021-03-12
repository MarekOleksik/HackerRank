package hackerrank.Java10DaysOfStatistics.Day5.PoissonDistributionI;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double x = scanner.nextDouble();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int variable = scanner.nextInt();
        System.out.printf("%.3f\n", findPoissonProbability(variable, x));


    }

    private static double findPoissonProbability(int k, double l) {
        double e = Math.E;
        return Math.pow(l, k) * Math.pow(e, -l) / factorial(k);

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