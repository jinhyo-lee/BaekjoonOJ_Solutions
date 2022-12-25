import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            pq.offer(Integer.parseInt(br.readLine()));

        int cnt = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();

            cnt += sum;
            pq.offer(sum);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
