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
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            while (n-- > 0)
                set.add(Integer.parseInt(br.readLine()));

            int cnt = 0;
            while (m-- > 0) {
                int num = Integer.parseInt(br.readLine());
                if (set.contains(num))
                    cnt++;
            }

            sb.append(cnt).append("\n");
            set.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
