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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        int time = arr[0].s;
        for (int i = 0; i < n; i++)
            time = Math.min(time, arr[i].s) - arr[i].t;

        bw.write(String.valueOf(Math.max(time, -1)));
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        int t, s;

        public Pair(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            return o.s != this.s ? o.s - this.s : o.t - this.t;
        }
    }

}
