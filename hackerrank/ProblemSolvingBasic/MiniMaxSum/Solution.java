package hackerrank.ProblemSolvingBasic.MiniMaxSum;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = 0;
        long max = 0;

        for (int i = 0; i < 4; i++) {
            min += arr[i];
        }
        for (int i = arr.length - 4; i < arr.length; i++) {
            max += arr[i];
        }
        System.out.println(min + " " + max);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
