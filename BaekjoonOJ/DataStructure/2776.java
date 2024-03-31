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
            Set<Integer> set = new HashSet<>();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (n-- > 0) set.add(Integer.parseInt(st.nextToken()));

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (m-- > 0) sb.append(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
