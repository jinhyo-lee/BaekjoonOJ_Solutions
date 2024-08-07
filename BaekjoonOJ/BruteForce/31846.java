import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static String s;
    static int l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()) - 1;
            r = Integer.parseInt(st.nextToken()) - 1;

            int max = 0;
            for (int i = l; i < r; i++) max = Math.max(max, count(i));
            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int count(int i) {
        int cnt = 0, j = i + 1;
        while (i >= l && j <= r) if (s.charAt(i--) == s.charAt(j++)) cnt++;

        return cnt;
    }

}
