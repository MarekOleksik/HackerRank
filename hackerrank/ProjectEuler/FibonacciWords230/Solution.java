package hackerrank.ProjectEuler.FibonacciWords230;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int numberOfTriples = Integer.parseInt(reader.readLine());

        List<String> lines = new LinkedList<>();

        for (int i = 0; i < numberOfTriples; i++) {
            lines.add(reader.readLine());
        }

        for (String line : lines) {
            String[] partOfLine = line.split(" ");
            StringBuilder firstNumber = new StringBuilder(partOfLine[0]);
            StringBuilder secondNumber = new StringBuilder(partOfLine[1]);

            long digit = Long.parseLong(partOfLine[2]);
            long stringLength = 0;
            StringBuilder result = new StringBuilder();


            while (stringLength <= digit) {

                result = firstNumber.append(secondNumber);
                firstNumber = secondNumber;
                secondNumber = result;
               // System.out.println(result);
                stringLength = result.length();
            }

            System.out.println(result.charAt((int) digit - 1));
        }
    }

}
