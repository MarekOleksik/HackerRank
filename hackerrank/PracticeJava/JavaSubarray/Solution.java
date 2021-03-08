package hackerrank.PracticeJava.JavaSubarray;

import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int lengthOfArray = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] arrRowItems = scanner.nextLine().split(" ");
        int[] arr = new int[lengthOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            arr[i] = Integer.parseInt(arrRowItems[i]);
        }

        int n = arr.length;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum < 0) counter++;
            }
        }

        System.out.println(counter);
    }
}

