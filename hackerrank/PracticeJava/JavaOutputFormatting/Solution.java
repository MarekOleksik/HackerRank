package hackerrank.PracticeJava.JavaOutputFormatting;



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            map.put(s1, x);
        }
        System.out.println("================================");
        map.forEach((key, value) -> System.out.printf("%-15s%03d\n", key, value));

        System.out.println("================================");

    }
}

