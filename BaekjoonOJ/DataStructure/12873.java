import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            q.offer(i);

        for (int i = 1; i < n; i++, q.poll()) {
            long num = ((long) i * i * i - 1) % q.size();
            while (num-- > 0)
                q.offer(q.poll());
        }

        bw.write(String.valueOf(q.poll()));
        bw.flush();
    }

}
