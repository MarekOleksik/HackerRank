package hackerrank.PracticeJava.JavaBitSet;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

//TODO
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitsetLength = scanner.nextInt();
        int numberOfOperations = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        BitSet bitSet1 = new BitSet(bitsetLength);
        BitSet bitSet2 = new BitSet(bitsetLength);
        List<String> results = new ArrayList<>();

        for (int i = 0; i < bitsetLength; i++) {
            bitSet1.set(i, false);
            bitSet2.set(i, false);
        }

        System.out.println(bitSet2);

        for (int i = 0; i < numberOfOperations; i++) {
            String[] line = scanner.nextLine().split(" ");
            int set1 = Integer.parseInt(line[1]);
            int set2 = Integer.parseInt(line[2]);
            String result = bitSet1.toString() + " " + bitSet2.toString();

            switch (line[0]) {
                case "AND": {
                    bitSet2.and(bitSet1);

                }
                break;
                case "SET": {
                    if (set1 == 1) {
                        bitSet1.set(set2);
                    } else if (set1 == 2) {
                        bitSet2.set(set2);
                    }
                    results.add(result);
                }
            }
        }

        for (String res : results) {
            System.out.println(res);
        }

    }
}
