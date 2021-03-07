package hackerrank.Java10DaysOfStatistics.Day0.MeanMedianMode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfElements = scan.nextInt();
        List<Integer> array = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < numberOfElements; i++) {
            array.add(scan.nextInt());
        }
        double sum = array.stream().mapToDouble(f -> f.doubleValue()).sum();
        double mean = sum / numberOfElements;

        Collections.sort(array);

        int middle = ((array.size()) / 2);
        double median;
        if (array.size() % 2 == 0) {
            double medianA = array.get(middle);
            double medianB = array.get(middle - 1);
            median = (medianA + medianB) / 2;
        } else {
            median = array.get(middle + 1);
        }

        for (int num : array) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }

        int mode = array.get(0);
        int max = Collections.max(map.values());
        if (max > 1) {
            mode = getKey(map, max);
        }

        System.out.printf("%.1f\n", mean);
        System.out.printf("%.1f\n", median);
        System.out.println(mode);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        return map.keySet()
                .stream()
                .filter(key -> value.equals(map.get(key)))
                .findFirst().get();
    }
}
