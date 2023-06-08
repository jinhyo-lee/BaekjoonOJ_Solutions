import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int balance = 3000000;
    static int[] arr = new int[12];
    static boolean[] visit = new boolean[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 12; i++)
            arr[i] = Integer.parseInt(br.readLine());

        recur(0, 0, 0, 0, 3000000, 0);

        bw.write(String.valueOf(balance));
        bw.flush();
    }

    private static void recur(int sum, int idx, int cnt, int team, int min, int max) {
        if (team == 4) {
            balance = Math.min(balance, max - min);
            return;
        }

        if (cnt == 3)
            recur(0, 0, 0, team + 1, Math.min(min, sum), Math.max(max, sum));

        for (int i = idx; i < 12; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            recur(sum + arr[i], i + 1, cnt + 1, team, min, max);
            visit[i] = false;
        }
    }

}
