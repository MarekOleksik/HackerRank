package hackerrank.PracticeJava.JavaBigDecimal;

import java.math.BigDecimal;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, 0, n, (Comparator<Object>) (a1, a2) -> {
            BigDecimal bigDec1 = new BigDecimal((String) a1);
            BigDecimal bigDec2 = new BigDecimal((String) a2);
            return bigDec2.compareTo(bigDec1);
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}