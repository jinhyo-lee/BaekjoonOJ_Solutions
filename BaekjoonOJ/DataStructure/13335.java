import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        while (w-- > 0)
            q.offer(0);

        st = new StringTokenizer(br.readLine());
        int time = 0, weight = 0, truck = Integer.parseInt(st.nextToken());

        while (true) {
            time++;
            weight -= q.poll();
            if (weight + truck <= l) {
                weight += truck;
                q.offer(truck);

                if (--n == 0)
                    break;

                truck = Integer.parseInt(st.nextToken());
            } else
                q.offer(0);
        }

        bw.write(String.valueOf(time + q.size()));
        bw.flush();
    }

}
