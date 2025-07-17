import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        Pair p = new Pair(br.readLine());
        int n = Integer.parseInt(p.s), m = p.i;
        while (n-- > 0) map.put((p = new Pair(br.readLine())).s, p.i);

        int cnt = 0;
        while (m-- > 0) if (map.get((p = new Pair(br.readLine())).s) * 1.05 < p.i) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static class Pair {
        String s;
        int i;

        Pair(String s) {
            int i = s.indexOf(' ');
            this.s = s.substring(0, i);
            this.i = Integer.parseInt(s.substring(i + 1));
        }
    }

}
