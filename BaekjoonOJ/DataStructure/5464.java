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
        int m = Integer.parseInt(st.nextToken());

        Pair[] area = new Pair[n + 1];
        int[] weight = new int[m + 1];

        for (int i = 1; i <= n; i++)
            area[i] = new Pair(Integer.parseInt(br.readLine()));

        for (int i = 1; i <= m; i++)
            weight[i] = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        int income = 0;
        int size = 0;
        loop:
        for (int i = 0; i < m * 2; i++) {
            int car = Integer.parseInt(br.readLine());

            if (car > 0) {
                if (size < n) {
                    for (int j = 1; j <= n; j++) {
                        if (area[j].car == 0) {
                            area[j].car = car;
                            size++;
                            continue loop;
                        }
                    }
                } else
                    q.offer(car);
            } else {
                for (int j = 1; j <= n; j++) {
                    if (area[j].car == -car) {
                        area[j].car = 0;
                        income += area[j].cost * weight[-car];

                        if (!q.isEmpty())
                            area[j].car = q.poll();

                        if (area[j].car == 0)
                            size--;

                        break;
                    }
                }
            }
        }

        bw.write(String.valueOf(income));
        bw.flush();
    }

    private static class Pair {
        int cost, car;

        public Pair(int cost) {
            this.cost = cost;
            this.car = 0;
        }
    }

}
