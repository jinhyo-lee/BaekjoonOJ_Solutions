import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean[] arr = new boolean[n + 1];
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                int i = s.indexOf('-'), l, h;
                if (i != -1) {
                    l = Integer.parseInt(s.substring(0, i));
                    h = Integer.parseInt(s.substring(i + 1));
                } else {
                    l = Integer.parseInt(s);
                    h = l;
                }

                for (; l <= n && l <= h; l++) {
                    if (arr[l]) continue;
                    arr[l] = true;
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
