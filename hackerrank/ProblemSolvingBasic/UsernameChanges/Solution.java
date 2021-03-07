package hackerrank.ProblemSolvingBasic.UsernameChanges;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'possibleChanges' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY usernames as parameter.
     */

    public static List<String> possibleChanges(List<String> usernames) {
        List<String> results = new ArrayList<>();

        for (String username : usernames) {
            char[] chars = username.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            System.out.println("Username: " + username + ", sorted: " + sorted);
            System.out.println("Condition: " + (username.charAt(0) > sorted.charAt(0)));
            if (username.charAt(0) > sorted.charAt(0)) {
                results.add("YES");
            } else if (username.charAt(0) == sorted.charAt(0)) {
                char[] user = username.toCharArray();
                boolean canBeChanged = false;

                for (int i = 1; i < user.length; i++) {
                    if (user[i] < user[i - 1]) {
                        canBeChanged = true;
                    }
                }

                if (canBeChanged) {
                    results.add("YES");
                } else {
                    results.add("NO");
                }
            } else {
                results.add("NO");
            }
        }

        return results;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int usernamesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> usernames = IntStream.range(0, usernamesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.possibleChanges(usernames);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

