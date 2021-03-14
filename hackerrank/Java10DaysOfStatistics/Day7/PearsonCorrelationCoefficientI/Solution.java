package hackerrank.Java10DaysOfStatistics.Day7.PearsonCorrelationCoefficientI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<Double> setX = getDataSetFromScanner(n);
        List<Double> setY = getDataSetFromScanner(n);
        System.out.printf("%.3f\n", getPearsonCorrelation(setX, setY));
    }

    private static double getPearsonCorrelation(List<Double> setX, List<Double> setY) {
        double meanX = getMean(setX);
        double deviationX = getDeviation(setX);
        double meanY = getMean(setY);
        double deviationY = getDeviation(setY);
        double numerator = 0;

        for (int i = 0; i < setX.size(); i++) {
            numerator += (setX.get(i) - meanX) * (setY.get(i) - meanY);
        }

        double pearson = numerator / (setX.size() * deviationX * deviationY);

        return pearson;
    }

    private static double getDeviation(List<Double> list) {
        double squaredDistance = 0;

        for (double num : list) {
            squaredDistance += Math.pow(num - getMean(list), 2);
        }

        double deviation = Math.sqrt(squaredDistance / list.size());

        return deviation;
    }

    private static double getMean(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum() / list.size();
    }

    private static List<Double> getDataSetFromScanner(int n) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextDouble());
        }
        return list;
    }
}
