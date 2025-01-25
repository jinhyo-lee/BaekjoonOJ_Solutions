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
        StringBuilder sb = new StringBuilder();

        Map<String, Character> map = new HashMap<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char v = st.nextToken().charAt(0);
            map.put(st.nextToken(), v);
        }

        String s = br.readLine();
        for (int i = 0; i < s.length(); i += 4) sb.append(map.getOrDefault(s.substring(i, i + 4), '?'));

        bw.write(sb.toString());
        bw.flush();
    }

}
