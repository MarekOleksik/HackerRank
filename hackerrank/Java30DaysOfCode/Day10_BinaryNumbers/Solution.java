package hackerrank.Java30DaysOfCode.Day10_BinaryNumbers;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String binary = Integer.toBinaryString(n);
        int max = 0;
        int temp = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            } else {
                temp = 0;
            }
        }

        System.out.println(max);

        scanner.close();
    }
}
