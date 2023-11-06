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

        Map<String, Integer> map = new HashMap<>();

        int q = Integer.parseInt(br.readLine()), cnt = 0;
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (st.nextToken().equals("+")) map.put(s, map.getOrDefault(s, 0) + 1);
            else if (map.getOrDefault(s, 0) == 0) cnt++;
            else map.put(s, map.getOrDefault(s, 0) - 1);
        }

        for (int value : map.values()) cnt += value;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
