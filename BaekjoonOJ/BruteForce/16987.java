import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, max;
    static int[] hard, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        hard = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hard[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int idx) {
        if (idx == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (hard[i] <= 0)
                    cnt++;
            }

            max = Math.max(max, cnt);
            return;
        }

        if (hard[idx] <= 0)
            recur(idx + 1);
        else {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (i == idx || hard[i] <= 0)
                    continue;
                flag = true;

                hard[i] -= weight[idx];
                hard[idx] -= weight[i];
                recur(idx + 1);
                hard[i] += weight[idx];
                hard[idx] += weight[i];
            }

            if (flag == false)
                recur(idx + 1);
        }
    }

}
