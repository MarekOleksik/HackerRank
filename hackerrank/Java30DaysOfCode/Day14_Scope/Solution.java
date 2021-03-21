package hackerrank.Java30DaysOfCode.Day14_Scope;

import java.util.Scanner;


class Difference {
    private int[] elements;
    public int maximumDifference;

    public Difference(int[] a) {
        this.elements = a;
    }

    public void computeDifference() {
        maximumDifference = Integer.MIN_VALUE;

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if (j == i) continue;
                int absDifference = Math.abs(elements[i] - elements[j]);
                if (absDifference > maximumDifference) {
                    maximumDifference = absDifference;
                }
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}