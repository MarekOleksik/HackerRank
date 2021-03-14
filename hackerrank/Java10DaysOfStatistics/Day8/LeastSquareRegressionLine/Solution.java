package hackerrank.Java10DaysOfStatistics.Day8.LeastSquareRegressionLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> setX = new ArrayList<>(Arrays.asList(95, 85, 80, 70, 60));
        List<Integer> setY = new ArrayList<>(Arrays.asList(85, 95, 70, 65, 70));

        double n = setX.size();
        double sumOfSetX = setX.stream().mapToDouble(Integer::doubleValue).sum();
        double meanX = sumOfSetX / n;
        double sumOfSetY = setY.stream().mapToDouble(Integer::doubleValue).sum();
        double meanY = sumOfSetY / n;
        int squaredSumOfX = 0;
        int sumOfXMultiplyY = 0;

        for (int i = 0; i < setX.size(); i++) {
            squaredSumOfX += Math.pow(setX.get(i), 2);
            sumOfXMultiplyY += setX.get(i) * setY.get(i);
        }

        double b = (n * sumOfXMultiplyY - sumOfSetX * sumOfSetY) / (n * squaredSumOfX - Math.pow(sumOfSetX, 2));
        double a = meanY - b * meanX;

        double y = a + b * 80;
        System.out.printf("%.3f\n", y);
    }
}
