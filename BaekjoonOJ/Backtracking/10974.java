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

        arr = new int[n];
        visit = new boolean[n];

        recur(0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++)
                sb.append(arr[i]).append(" ");

            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;

            arr[depth] = i + 1;
            visit[i] = true;
            recur(depth + 1);
            visit[i] = false;
        }
    }

}
