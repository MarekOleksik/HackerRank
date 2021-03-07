package hackerrank.PracticeJava.JavaEndOfFile;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 1;
        Map<Integer, String> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            map.put(index, scanner.nextLine());
            index++;
        }
        map.forEach((key,value) -> System.out.println(key + " " + value));
    }
}