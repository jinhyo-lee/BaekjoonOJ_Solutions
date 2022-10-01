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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) ->
                o1.pay == o2.pay ? o1.day - o2.day : o2.pay - o1.pay);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(p, d));
        }

        boolean[] check = new boolean[10001];
        int max = 0;

        while (!pq.isEmpty()) {
            Lecture lec = pq.poll();
            for (int i = lec.day; i > 0; i--) {
                if (!check[i]) {
                    check[i] = true;
                    max += lec.pay;
                    break;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static class Lecture {
        int pay, day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

}
