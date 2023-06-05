import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String[] arr = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
    static Pair[] pairs;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        pairs = new Pair[n];
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");
            pairs[n] = new Pair(input[0], input[5]);
        }

        recur(new String[8], new boolean[8], 0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(String[] perm, boolean[] visit, int idx) {
        if (flag)
            return;

        if (idx == 8) {
            if (isLinedUp(perm)) {
                flag = true;
                for (String s : perm)
                    sb.append(s).append("\n");
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            perm[idx] = arr[i];
            recur(perm, visit, idx + 1);
            visit[i] = false;
        }
    }

    private static boolean isLinedUp(String[] perm) {
        int cnt = 0;
        for (Pair pair : pairs) {
            for (int i = 0; i < 7; i++) {
                if (perm[i].equals(pair.x) && perm[i + 1].equals(pair.y))
                    cnt++;
                if (perm[i].equals(pair.y) && perm[i + 1].equals(pair.x))
                    cnt++;
            }
        }

        return cnt == pairs.length;
    }

    private static class Pair {
        String x, y;

        public Pair(String x, String y) {
            this.x = x;
            this.y = y;
        }
    }

}
