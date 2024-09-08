import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[st.countTokens()];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());

            sb.append(recur(0, 0)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int recur(int i, int sum) {
        if (i >= arr.length) return sum;

        return Math.max(recur(i + 1, sum), recur(i + 2, sum + arr[i]));
    }

}
