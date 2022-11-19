import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            pq.offer(Long.parseLong(st.nextToken()));

        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();

            pq.offer(a + b);
            pq.offer(a + b);
        }

        long res = 0;
        for (int i = 0; i < n; i++)
            res += pq.poll();

        bw.write(String.valueOf(res));
        bw.flush();
    }

}
