package hackerrank.Java30DaysOfCode.Day26_NestedLogic;

import java.time.LocalDate;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d1 = scanner.nextInt();
        int m1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int d2 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        LocalDate returnedDate = LocalDate.of(y1, m1, d1);
        LocalDate expectedDate = LocalDate.of(y2, m2, d2);
        int fine = 0;

        if (returnedDate.isBefore(expectedDate)) {
            fine = 0;
        } else if (returnedDate.isAfter(expectedDate)) {
            if (returnedDate.getYear() == expectedDate.getYear()) {
                if (returnedDate.getMonth() == expectedDate.getMonth()) {
                    fine = 15 * (d1 - d2);
                } else {
                    fine = 500 * (m1 - m2);
                }
            } else {
                fine = 10000;
            }
        }
        System.out.println(fine);

    }
}
