package hackerrank.PracticeJava.JavaBitSet;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitsetLength = scanner.nextInt();
        int numberOfOperations = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        BitSet bitSet1 = new BitSet(bitsetLength);
        BitSet bitSet2 = new BitSet(bitsetLength);
        List<String> results = new ArrayList<>();

        for (int i = 0; i < numberOfOperations; i++) {
            String[] line = scanner.nextLine().split(" ");
            int set1 = Integer.parseInt(line[1]);
            int set2 = Integer.parseInt(line[2]);

            switch (line[0]) {
                case "AND": {
                    if (set1 == 1) {
                        bitSet1.and(bitSet2);
                    } else if (set1 == 2) {
                        bitSet2.and(bitSet1);
                    }
                }
                break;
                case "SET": {
                    if (set1 == 1) {
                        bitSet1.set(set2);
                    } else if (set1 == 2) {
                        bitSet2.set(set2);
                    }
                }
                break;
                case "FLIP": {
                    if (set1 == 1) {
                        bitSet1.flip(set2);
                    } else if (set1 == 2) {
                        bitSet2.flip(set2);
                    }
                }
                break;
                case "OR": {
                    if (set1 == 1) {
                        bitSet1.or(bitSet2);
                    } else if (set1 == 2) {
                        bitSet2.or(bitSet1);
                    }
                }
                break;
                case "XOR": {
                    if (set1 == 1) {
                        bitSet1.xor(bitSet2);
                    } else if (set1 == 2) {
                        bitSet2.xor(bitSet1);
                    }
                }
                break;
            }
            results.add(bitSet1.cardinality() + " " + bitSet2.cardinality());
        }

        for (String res : results) {
            System.out.println(res);
        }
    }
}
