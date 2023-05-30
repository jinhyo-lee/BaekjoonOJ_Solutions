import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int max, cnt, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while (cnt++ < n) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[5];
            for (int i = 0; i < 5; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            recur(0, 0, 0);
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static void recur(int sum, int idx, int depth) {
        if (depth == 3) {
            int digit = sum % 10;
            if (digit >= max) {
                max = digit;
                res = cnt;
            }
            return;
        }

        for (int i = idx; i < 5; i++)
            recur(sum + arr[i], i + 1, depth + 1);
    }

}
