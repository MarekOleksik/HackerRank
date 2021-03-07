package hackerrank.PracticeJava.PatternSyntaxChecker;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<String> list = new LinkedList<>();
        while (testCases > 0) {
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                list.add("Valid");
                testCases--;
            } catch (PatternSyntaxException e) {
                list.add("Invalid");
                testCases--;
            }
        }
        list.forEach(System.out::println);
    }
}
