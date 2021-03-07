package hackerrank.PracticeJava.JavaLoopsII;

import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] array = new String[t];
        String result = "";
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int serie = a + b;
            result = serie + " ";
            for (int j = 1; j < n; j++) {
                int exp = (int) Math.pow(2, j);
                serie += exp * b;
                result += serie + " ";
            }
            array[i] = result;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        in.close();
    }
}
