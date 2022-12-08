import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] dist;
    static final int inf = 251;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    dist[i][j] = inf;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            if (src == -1 && dest == -1)
                break;

            dist[src][dest] = dist[dest][src] = 1;
        }

        floydWarshall();

        int lead = inf;
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int score = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] != inf)
                    score = Math.max(score, dist[i][j]);
            }

            scores[i] = score;
            lead = Math.min(lead, score);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (lead == scores[i]) {
                sb.append(i + " ");
                cnt++;
            }
        }

        bw.write(lead + " " + cnt + "\n" + sb);
        bw.flush();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k)
                    continue;
                for (int j = 1; j <= n; j++) {
                    if (j == i || j == k)
                        continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

}
