package hackerrank.PracticeJava.JavaBigInteger;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstNumber = scan.next();
        String secondNumber = scan.next();
        BigInteger a = new BigInteger(firstNumber);
        BigInteger b = new BigInteger(secondNumber);
        System.out.println(a.add(b).toString());
        System.out.println(a.multiply(b).toString());
    }
}