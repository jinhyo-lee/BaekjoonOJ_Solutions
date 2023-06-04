import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[2][10];
    static boolean[][] visit = new boolean[2][10];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

    private static void recur(int day, int sum) {
        if (day == 4) {
            set.add(sum);
            return;
        }

        if (day + 2 <= 4)
            recur(day + 2, sum);

        int tgt = day & 1;
        for (int i = 0; i < 10; i++) {
            if (visit[tgt][i])
                continue;

            visit[tgt][i] = true;
            recur(day + 1, sum + arr[tgt][i] * (tgt == 1 ? 1 : -1));
            visit[tgt][i] = false;
        }
    }

}
