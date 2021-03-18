package hackerrank.PracticeJava.JavaStack;

import java.util.*;

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        boolean result = true;
        List<Boolean> results = new LinkedList<>();

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> stack = new Stack();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[')
                    stack.push(input.charAt(i));
                else if (input.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        result = false;
                        break;
                    }
                } else if (input.charAt(i) == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        result = false;
                        break;
                    }
                } else if (input.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        result = false;
                        break;
                    }
                } else result = stack.isEmpty();
            }

            results.add(result);
        }

        for (boolean res : results) {
            System.out.println(res);
        }
    }
}

