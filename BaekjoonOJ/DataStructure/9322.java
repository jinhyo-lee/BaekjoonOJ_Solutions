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
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                map.put(st.nextToken(), i);

            int[] pattern = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                pattern[i] = map.get(st.nextToken());

            String[] res = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                res[pattern[i]] = st.nextToken();

            for (String s : res)
                sb.append(s).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
