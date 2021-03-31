package hackerrank.Java30DaysOfCode.Day25_RunningTimeandComplexity;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> results = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            String result = "";
            if (number == 1) {
                result = "Not prime";
            }
            if (number == 2) {
                results.add("Prime");
                break;
            }

            for (int j = 2; j * j <= number; j++) {

                if (number % j == 0) {
                    result = "Not prime";
                    break;
                } else {
                    result = "Prime";
                }
            }
            results.add(result);
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}