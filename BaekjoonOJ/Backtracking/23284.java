import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visit = new boolean[n + 1];

        recur(1, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int depth, int next) {
        if (depth == n + 1) {
            for (int i = 1; i <= n; i++)
                sb.append(arr[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i])
                continue;

            if (i > arr[depth - 1] && i < next)
                break;

            arr[depth] = i;
            visit[i] = true;
            if (i >= next)
                recur(depth + 1, i + 1);
            else
                recur(depth + 1, next);
            visit[i] = false;
        }
    }

}
