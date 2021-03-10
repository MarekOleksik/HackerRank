package hackerrank.PracticeJava.JavaMap;

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        Map<String, Integer> phoneBook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            int phone = scan.nextInt();
            phoneBook.put(name, phone);
            scan.nextLine();
        }

        List<String> results = new LinkedList<>();
        while (scan.hasNext()) {
            String s = scan.nextLine();
            int phoneNumber = phoneBook.getOrDefault(s, 0);
            if (phoneNumber == 0) {
                results.add("Not found");
            } else {
                results.add(s + "=" + phoneNumber);
            }
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}
