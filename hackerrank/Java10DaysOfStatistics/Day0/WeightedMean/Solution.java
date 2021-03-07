package hackerrank.Java10DaysOfStatistics.Day0.WeightedMean;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        List<Integer> arrayX = new LinkedList<>();
        List<Integer> arrayW = new LinkedList<>();

        for (int i = 0; i < numberOfElements; i++) {
            arrayX.add(scan.nextInt());
        }

        for (int i = 0; i < numberOfElements; i++) {
            arrayW.add(scan.nextInt());
        }

        double sumNominator = 0;
        double sumDenominator = arrayW.stream().mapToInt(Integer::intValue).sum();

        for (int i = 0; i < arrayX.size(); i++) {
            sumNominator += arrayX.get(i) * arrayW.get(i);
        }

        double result = sumNominator / sumDenominator;
        System.out.printf("%.1f\n", result);
    }
}
