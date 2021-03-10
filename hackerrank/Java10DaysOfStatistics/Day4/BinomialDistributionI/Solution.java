package hackerrank.Java10DaysOfStatistics.Day4.BinomialDistributionI;

import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double n = scanner.nextDouble();
        int q = scanner.nextInt();
        double boysProbability = n / (n + q);
        double probability = 0;
        for (int i = 3; i <= 6; i++) {
            probability += calculateCombination(i, 6) * Math.pow(boysProbability, i) * Math.pow(1 - boysProbability, 6 - i);
        }

        System.out.printf("%.3f", probability);
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
