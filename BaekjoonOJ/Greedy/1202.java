import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Gem> gems = new PriorityQueue<>((o1, o2) -> {
            if (o1.mass == o2.mass)
                return o2.value - o2.value;

            return o1.mass - o2.mass;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems.offer(new Gem(m, v));
        }

        int[] bag = new int[k];
        for (int i = 0; i < k; i++)
            bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bag);

        PriorityQueue<Integer> values = new PriorityQueue<>((o1, o2) -> o2 - o1);

        long max = 0;
        for (int i = 0; i < k; i++) {
            int mass = bag[i];
            while (!gems.isEmpty()) {
                if (gems.peek().mass <= mass)
                    values.offer(gems.poll().value);
                else
                    break;
            }

            if (values.isEmpty())
                continue;
            max += values.poll();
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static class Gem {
        int mass, value;

        public Gem(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
    }

}
