package hackerrank.PracticeJava.JavaPrimalityTest;

import java.math.*;
import java.util.*;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();

        scanner.close();

        BigInteger bigInteger = new BigInteger(n);
        boolean isPrime = bigInteger.isProbablePrime(1);
        if (isPrime) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
