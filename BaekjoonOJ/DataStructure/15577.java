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

        PriorityQueue<Double> pq = new PriorityQueue<>();
        while (n-- > 0) pq.offer(Double.parseDouble(br.readLine()));

        double avg = !pq.isEmpty() ? pq.poll() : 0.0;
        while (!pq.isEmpty()) avg = (avg + pq.poll()) / 2.0;

        bw.write(String.valueOf(avg));
        bw.flush();
    }

}
