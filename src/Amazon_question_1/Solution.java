package Amazon_question_1;

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


class Result1 {

    /*
     * Complete the 'sortOrders' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY sorterOrder as parameter.
     */

    public static int sortOrders(List<Integer> sorterOrder) {
        // Write your code here


        int n = sorterOrder.size();
        int[] pos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int value = sorterOrder.get(i);
            pos[value] = i;
        }

        int passes = 1;
        for (int i = 2; i <= n; i++) {
            if (pos[i] < pos[i - 1]) {
                passes++;
            }
        }

        return passes;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int sorterOrderCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sorterOrder = IntStream.range(0, sorterOrderCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result1.sortOrders(sorterOrder);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

