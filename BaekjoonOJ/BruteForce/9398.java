import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int len = s.length(), min = Integer.MAX_VALUE, uc = 0, lc = 0, dc = 0, l = 0;
            for (int r = 0; r < len; r++) {
                char c = s.charAt(r);
                if (c >= 'A' && c <= 'Z') uc++;
                else if (c >= 'a' && c <= 'z') lc++;
                else if (c >= '0' && c <= '9') dc++;

                while (uc > 0 && lc > 0 && dc > 0) {
                    int cur = r - l + 1;
                    if (cur < 6) break;
                    min = Math.min(min, cur);

                    c = s.charAt(l);
                    if (c >= 'A' && c <= 'Z') uc--;
                    else if (c >= 'a' && c <= 'z') lc--;
                    else if (c >= '0' && c <= '9') dc--;
                    l++;
                }
            }
            sb.append(min == Integer.MAX_VALUE ? 0 : min).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
