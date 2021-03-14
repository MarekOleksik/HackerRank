package hackerrank.Java30DaysOfCode.Day8_DictionariesAndMaps;

import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> phonebook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            phonebook.put(name, phone);
        }

        List<String> results = new ArrayList<>();

        while (in.hasNext()) {
            String s = in.next();
            int result = phonebook.getOrDefault(s, 0);
            if (result == 0) {
                results.add("Not found");
            } else {
                results.add(s + "=" + result);
            }
        }
        in.close();

        for (String res : results) {
            System.out.println(res);
        }
    }
}