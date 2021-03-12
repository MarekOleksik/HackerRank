package hackerrank.Java10DaysOfStatistics.Day6.TheCentralLimitTheoremIII;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sampleSize = scanner.nextInt(); //100
        double mean = scanner.nextDouble(); //500
        double deviation = scanner.nextDouble(); //80
        double percentageDistribution = scanner.nextDouble(); //.95
        double valueOfZ = scanner.nextDouble(); //1.96

        double deviationPrim = deviation / Math.sqrt(sampleSize);

        double A = mean - valueOfZ * deviationPrim;
        double B = mean + valueOfZ * deviationPrim;

        System.out.printf("%.2f\n", A);
        System.out.printf("%.2f\n", B);
    }
}