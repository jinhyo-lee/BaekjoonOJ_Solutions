import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Set<String> set = new HashSet<>();
            int idx = l - f, cnt = 0;
            while (n-- > 0) {
                String tail = st.nextToken().substring(idx);
                if (set.contains(tail)) {
                    set.remove(tail);
                    cnt++;
                } else set.add(tail);
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
