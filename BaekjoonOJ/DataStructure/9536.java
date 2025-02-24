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

        Set<String> set = new HashSet<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) set.add(st.nextToken());
            st = new StringTokenizer(s);

            while (!(s = br.readLine()).startsWith("what")) set.remove(s.substring(s.indexOf("goes ") + 5));
            while (st.hasMoreTokens()) if (set.contains(s = st.nextToken())) sb.append(s).append(" ");

            sb.append('\n');
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
