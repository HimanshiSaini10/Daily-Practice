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
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        List<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        int lastIndex = 0;
        for(int i=0; i<queries.size(); i++) {
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            if(queries.get(i).get(0) == 1) {
                System.out.println("HERE IN 1");
                int ind = ( x ^ lastIndex) % n;
                arr.get(ind).add(y);
            } else if(queries.get(i).get(0) == 2) {
                System.out.println("HERE IN 2");
                int ind = (x ^ lastIndex) % n;
                lastIndex = arr.get(ind).get(y % arr.get(ind).size());
                ans.add(lastIndex);
            }
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
