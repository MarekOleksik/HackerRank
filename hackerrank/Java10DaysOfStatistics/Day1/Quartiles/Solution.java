package hackerrank.Java10DaysOfStatistics.Day1.Quartiles;

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
        Collections.sort(array);

        double medianQ2 = findMedian(array);

        List<Integer> arrayLowerHalf = new ArrayList<>();
        List<Integer> arrayUpperHalf = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < medianQ2) {
                arrayLowerHalf.add(array.get(i));
            } else if (array.get(i) > medianQ2) {
                arrayUpperHalf.add(array.get(i));
            }
        }

        double medianQ1 = findMedian(arrayLowerHalf);
        double medianQ3 = findMedian(arrayUpperHalf);

        System.out.printf("%.0f\n", medianQ1);
        System.out.printf("%.0f\n", medianQ2);
        System.out.printf("%.0f\n", medianQ3);

    }

    private static double findMedian(List<Integer> array) {
        int middle = ((array.size()) / 2);
        double median;
        if (array.size() % 2 == 0) {
            double medianA = array.get(middle);
            double medianB = array.get(middle - 1);
            median = (medianA + medianB) / 2;
        } else {
            median = array.get(middle);
        }
        return median;
    }
}