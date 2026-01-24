import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' '))), l = Integer.parseInt(s.substring(s.indexOf(' ') + 1)), max = 0, sum = 0;
        while (n-- > 0) {
            s = br.readLine();
            int cnt = s.charAt(0) - '0';
            for (int i = 1; i < l; i++) if (s.charAt(i) == '1' && s.charAt(i - 1) != '1') cnt++;

            if (max < cnt) {
                max = cnt;
                sum = 1;
            } else if (max == cnt) sum++;
        }

        bw.write(max + " " + sum);
        bw.flush();
    }

}
