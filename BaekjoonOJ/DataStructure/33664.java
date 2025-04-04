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

        Map<String, Long> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), Long.parseLong(st.nextToken()));
        }

        long sum = 0;
        while (m-- > 0) sum += map.get(br.readLine());

        bw.write(sum > b ? "unacceptable" : "acceptable");
        bw.flush();
    }

}
