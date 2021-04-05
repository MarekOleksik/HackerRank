package hackerrank.Java30DaysOfCode.Day28_RegExPatternsAndIntroToDatabases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<String> names = new ArrayList<>();
        String myRegExString = "@gmail.com";
        Pattern p = Pattern.compile(myRegExString);

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];

            Matcher m = p.matcher(emailID);
            if (m.find()) {
                names.add(firstName);
            }
        }

        Collections.sort(names);

        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
