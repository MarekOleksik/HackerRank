package hackerrank.JavaSubstringComparisons;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        SortedSet<String> setOfSubstrings = new TreeSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            setOfSubstrings.add(s.substring(i, i + k));
        }
        smallest = setOfSubstrings.first();
        largest = setOfSubstrings.last();

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}