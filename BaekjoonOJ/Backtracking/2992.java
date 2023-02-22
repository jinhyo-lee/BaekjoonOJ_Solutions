import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[] arr;
    static boolean[] visit;
    static int num, len, min = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x = br.readLine();

        arr = x.toCharArray();
        num = Integer.parseInt(x);
        len = x.length();
        visit = new boolean[len];

        recur(0);

        bw.write(String.valueOf(min == Integer.MAX_VALUE ? "0" : min));
        bw.flush();
    }

    private static void recur(int depth) {
        if (depth == len) {
            int tmp = Integer.parseInt(sb.toString());
            if (tmp > num && tmp < min)
                min = tmp;

            return;
        }

        for (int i = 0; i < len; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            sb.append(arr[i]);
            recur(depth + 1);
            visit[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
