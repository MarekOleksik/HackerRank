package hackerrank.ProblemSolvingBasic.TimeConversion;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        boolean isAm = false;

        if (s.contains("AM")) {
            isAm = true;
        }

        s = s.replace("PM", "").replace("AM", "");
        String[] contents = s.split(":");
        String hours = contents[0];
        String minutes = contents[1];
        String seconds = contents[2];

        if (isAm) {
            if ("12".equals(hours)) {
                hours = "00";
            }
        } else {
            int h = Integer.parseInt(hours);
            h += 12;
            if (h == 24) {
                hours = "12";
            } else {
                hours = String.valueOf(h);
            }
        }

        return hours + ":" + minutes + ":" + seconds;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String s = scan.nextLine();
        String s = "07:05:45PM";

        String result = timeConversion(s);
        System.out.println(result);

        // bw.write(result);
        //bw.newLine();

        //bw.close();
    }
}
