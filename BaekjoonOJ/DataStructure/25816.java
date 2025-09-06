import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Counter> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            Counter c = map.get(s);
            if (c == null) map.put(s, new Counter(i, 1));
            else c.count(i);
        }

        Pair[] arr = new Pair[map.size()];
        int i = 0;
        for (Entry<String, Counter> entry : map.entrySet())
            arr[i++] = new Pair(entry.getKey(), (float) entry.getValue().sum / entry.getValue().cnt);
        Arrays.sort(arr);

        for (Pair p : arr) sb.append(p.s).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Counter {
        int sum, cnt;

        Counter(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }

        public void count(int i) {
            sum += i;
            cnt++;
        }
    }

    private static class Pair implements Comparable<Pair> {
        String s;
        float f;

        Pair(String s, float f) {
            this.s = s;
            this.f = f;
        }

        @Override
        public int compareTo(Pair o) {
            return Float.compare(this.f, o.f);
        }
    }

}
