import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long w = Integer.parseInt(st.nextToken());

        long cnt = 0;
        int prev = Integer.parseInt(br.readLine());

        while (n-- > 1) {
            int cur = Integer.parseInt(br.readLine());
            if (cur > prev) {
                cnt += w / prev;
                w %= prev;
            } else if (cur < prev) {
                w += prev * cnt;
                cnt = 0;
            }
            prev = cur;
        }

        bw.write(String.valueOf(w + prev * cnt));
        bw.flush();
    }

}
