package hackerrank.PracticeJava.CompareTheTriplets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {


    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> results = new ArrayList<>();
        int resultA = 0;
        int resultB = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                resultA++;
            } else if (a.get(i) < b.get(i)) {
                resultB++;
            }
        }
        results.add(resultA);
        results.add(resultB);

        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

