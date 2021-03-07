package hackerrank.Java10DaysOfStatistics.Day1.InterquartileRange;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        List<Integer> arrayX = new LinkedList<>();

        for (int i = 0; i < numberOfElements; i++) {
            arrayX.add(scan.nextInt());
        }

        for (int i = 0; i < numberOfElements; i++) {
            int elementsInArray = scan.nextInt();
            for (int j = 1; j < elementsInArray; j++) {
                arrayX.add(arrayX.get(i));
            }
        }

        Collections.sort(arrayX);

        double medianQ2 = findMedian(arrayX);

        List<Integer> arrayLowerHalf = new ArrayList<>();
        List<Integer> arrayUpperHalf = new ArrayList<>();
        int medium = arrayX.size() / 2;

        for (int i = 0; i < medium; i++) {
            arrayLowerHalf.add(arrayX.get(i));
        }
        for (int i = medium + 1; i < arrayX.size(); i++) {
            arrayUpperHalf.add(arrayX.get(i));

        }

        double medianQ1 = findMedian(arrayLowerHalf);
        double medianQ3 = findMedian(arrayUpperHalf);

        System.out.println(medianQ3 - medianQ1);

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