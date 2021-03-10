package hackerrank.PracticeJava.JavaList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfElements = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] elementsOfList = scan.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for (String element : elementsOfList) {
            list.add(Integer.parseInt(element));
        }

        int numberOfQueries = scan.nextInt();
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < numberOfQueries; i++) {
            String query = scan.nextLine();
            String[] values = scan.nextLine().split(" ");
            int value = 0;
            int index = Integer.parseInt(values[0]);
            if ("Insert".equals(query)) {
                value = Integer.parseInt(values[1]);
                list.add(index, value);
            } else if ("Delete".equals(query)) {
                list.remove(index);
            }
        }

        for (int l : list) {
            System.out.print(l + " ");
        }
    }
}
