import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.src - o2.src;
            }
        });

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i].dest > pairs[j].dest && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }

            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(n - max));
        bw.flush();
    }

    private static class Pair {
        int src, dest;

        public Pair(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

}
