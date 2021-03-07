package hackerrank.Java10DaysOfStatistics.Day1.StandardDeviation;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < numberOfElements; i++) {
            array.add(scan.nextInt());
        }

        double sum = array.stream().mapToDouble(f -> f.doubleValue()).sum();
        double mean = sum / numberOfElements;
        double squaredDistance = 0;

        for (int num : array) {
            squaredDistance += Math.pow(num - mean, 2);
        }

        double standardDeviation = Math.sqrt(squaredDistance / numberOfElements);

        System.out.printf("%.1f\n", standardDeviation);
    }
}