package hackerrank.Java10DaysOfStatistics.Day7.SpearmansRankCorrelationCoefficient;

import java.util.*;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<Double> setX = getDataSetFromScanner(n);
        List<Double> setY = getDataSetFromScanner(n);
        System.out.printf("%.3f\n", getSpearmansRankCorrelation(setX, setY));
    }

    private static double getSpearmansRankCorrelation(List<Double> setX, List<Double> setY) {
        int n = setX.size();
        List<Double> copySetX = new ArrayList<>(setX);
        List<Double> copySetY = new ArrayList<>(setY);

        Collections.sort(copySetX);
        Collections.sort(copySetY);

        Map<Double, Integer> rankX = getRank(copySetX);
        Map<Double, Integer> rankY = getRank(copySetY);

        int sumOfSquaredDifference = getSumOfSquaredDifference(rankX, rankY, setX, setY);

        double spearmansRank = 1 - (6 * sumOfSquaredDifference / (n * (Math.pow(n, 2) - 1)));

        return spearmansRank;
    }

    private static int getSumOfSquaredDifference(Map<Double, Integer> rankX, Map<Double, Integer> rankY, List<Double> setX, List<Double> setY) {
        int sumOfSquaredDifference = 0;

        for (int i = 0; i < setX.size(); i++) {
            sumOfSquaredDifference += Math.pow(rankX.get(setX.get(i)) - rankY.get(setY.get(i)), 2);
        }

        return sumOfSquaredDifference;
    }

    private static Map<Double, Integer> getRank(List<Double> list) {
        Map<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i + 1);
        }

        return map;
    }

    private static List<Double> getDataSetFromScanner(int n) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextDouble());
        }
        return list;
    }
}
