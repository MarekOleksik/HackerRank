package hackerrank.ProblemSolvingBasic.GradingStudents;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Result {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> results = new LinkedList<>();

        for (int grade : grades) {
            int rest = grade % 5;
            if (grade < 37 || 5 - rest >= 3) {
                results.add(grade);
            } else if (5 - rest < 3) {
                results.add(grade + 5 - rest);
            }
        }

        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(gradesItem);
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
