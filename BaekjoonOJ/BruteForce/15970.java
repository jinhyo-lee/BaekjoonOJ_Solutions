import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int cnt = arr[0].color == arr[1].color ? arr[1].idx - arr[0].idx : 0;
        cnt += arr[n - 1].color == arr[n - 2].color ? arr[n - 1].idx - arr[n - 2].idx : 0;

        for (int i = 1; i < n - 1; i++) {
            Pair cur = arr[i], left = arr[i - 1], right = arr[i + 1];
            cnt += Math.min(cur.color == left.color ? cur.idx - left.idx : 1000000, cur.color == right.color ? right.idx - cur.idx : 1000000);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int idx, color;

        public Pair(int idx, int color) {
            this.idx = idx;
            this.color = color;
        }

        @Override
        public int compareTo(Pair o) {
            return this.color == o.color ? this.idx - o.idx : this.color - o.color;
        }
    }

}
