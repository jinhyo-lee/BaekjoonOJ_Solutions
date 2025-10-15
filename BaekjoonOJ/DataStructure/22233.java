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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        while (n-- > 0) set.add(br.readLine());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) set.remove(st.nextToken());
            sb.append(set.size()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
