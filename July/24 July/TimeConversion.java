import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String ans = "";
        if(s.substring(8).equals("AM")) {
            //AM
            if(s.substring(0,2).equals("12")) {
                ans += "00";
            } else {
                ans += s.substring(0,2);
            }
            ans += s.substring(2,8);
        } else {
            //PM
            if(!s.substring(0,2).equals("12")) {
                int v = Integer.parseInt(s.substring(0,2));
                v += 12;
                ans += v;
            } else {
                ans += s.substring(0,2);
            }
            ans += s.substring(2,8);
        }
        // System.out.println(ans);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
