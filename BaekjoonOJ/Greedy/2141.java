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
        long total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            arr[i] = new Pair(x, a);
            total += a;
        }

        Arrays.sort(arr);

        long sum = 0;
        for (Pair p : arr) {
            sum += p.a;
            if (sum >= (total + 1) / 2) {
                bw.write(String.valueOf(p.x));
                break;
            }
        }

        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        long x, a;

        public Pair(long x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Pair o) {
            return (int) (this.x == o.x ? this.a - o.a : this.x - o.x);
        }
    }

}
