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
        StringBuilder sb = new StringBuilder("\n");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        n -= m;

        Set<String> set = new HashSet<>();
        while (m-- > 0) {
            String s = br.readLine();
            set.add(s.substring(s.indexOf(" ") + 1));
        }

        int cnt = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken(), t = st.nextToken();
            if (!set.contains(t) && k > 0) {
                set.add(t);
                sb.append(s).append("\n");
                k--;
                cnt++;
            }
        }

        bw.write(sb.insert(0, cnt).toString());
        bw.flush();
    }

}
