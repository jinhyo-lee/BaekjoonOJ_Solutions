import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = read(), e = read();
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) arr[i] = read();

        int[] dist = new int[20001];
        Arrays.fill(dist, 20001);
        dist[0] = 0;

        for (int i : arr)
            for (int j = i; j < dist.length; j++) dist[j] = Math.min(dist[j], dist[j - i] + 1);

        int max = 0, cnt = 1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > e) {
                max = Math.max(max, i - cnt);
                cnt = i + 1;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
