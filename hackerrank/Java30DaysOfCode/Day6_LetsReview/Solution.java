package hackerrank.Java30DaysOfCode.Day6_LetsReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<String> results = new ArrayList<>();

        for (int i = 0; i < numberOfTests; i++) {
            char[] sequent = scanner.nextLine().toCharArray();
            String subsequent1 = "";
            String subsequent2 = "";

            for (int j = 0; j < sequent.length; j++) {
                if (j % 2 == 0) {
                    subsequent1 += sequent[j];
                } else {
                    subsequent2 += sequent[j];
                }
            }

            results.add(subsequent1 + " " + subsequent2);
        }

        for (String result : results) {
            System.out.println(result);
        }

    }
}
