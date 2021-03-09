package hackerrank.PracticeJava.JavaArraylist;

import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<List<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> lines = new ArrayList<>();
            int d = scanner.nextInt();

            for (int j = 0; j < d; j++) {
                lines.add(scanner.nextInt());
            }
            numbers.add(lines);
        }

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> results = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] newLine = scanner.nextLine().split(" ");
            int x = Integer.parseInt(newLine[0]);
            int y = Integer.parseInt(newLine[1]);

            try {
                results.add(String.valueOf(numbers.get(x - 1).get(y - 1)));
            } catch (Exception e) {
                results.add("ERROR!");
            }
        }

        for (String result : results) {
            System.out.println(result);
        }

    }
}
