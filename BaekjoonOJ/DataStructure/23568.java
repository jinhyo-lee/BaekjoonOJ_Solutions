import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), new Pair(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        int cur = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            Pair pair = map.get(cur);
            if (pair.dir.equals("L")) cur -= pair.dist;
            else cur += pair.dist;
        }

        bw.write(String.valueOf(cur));
        bw.flush();
    }

    private static class Pair {
        String dir;
        int dist;

        public Pair(String dir, int dist) {
            this.dir = dir;
            this.dist = dist;
        }
    }

}
