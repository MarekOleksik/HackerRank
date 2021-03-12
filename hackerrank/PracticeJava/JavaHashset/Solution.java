package hackerrank.PracticeJava.JavaHashset;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        Set<String> lines = new HashSet<>();
        List<Integer> counters = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        for (int i = 0; i < t; i++) {
            lines.add(pair_left[i] + " " + pair_right[i]);
            counters.add(lines.size());
        }

        for (int count : counters) {
            System.out.println(count);
        }

    }
}
