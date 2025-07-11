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

        String s = "";
        int n = Integer.parseInt(br.readLine()), sum = 0, max = 0;
        while (n-- > 0) {
            String p = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            if (m < k) continue;
            int cnt = (m - k) / (k - 2) + 1;
            sum += cnt;

            if (max < cnt) {
                max = cnt;
                s = p;
            }
        }

        bw.write(sum + "\n" + s);
        bw.flush();
    }

}
