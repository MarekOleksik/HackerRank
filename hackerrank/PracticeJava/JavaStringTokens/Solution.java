package hackerrank.PracticeJava.JavaStringTokens;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNext()) {
            System.out.println(0);
        } else {
            String s = scan.nextLine();
            String[] stringsS = s.trim().split("[ !,?._'@]+");
            System.out.println(stringsS.length);
            for (String item : stringsS) {
                System.out.println(item);
            }
        }
        scan.close();
    }

}
