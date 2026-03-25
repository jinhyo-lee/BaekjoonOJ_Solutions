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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()), max = 0;
            String res = "";
            while (n-- > 0) {
                String s = br.readLine();
                int l = Integer.parseInt(s.substring(s.indexOf(' ') + 1));
                s = s.substring(0, s.indexOf(' '));
                if (max < l) {
                    max = l;
                    res = s;
                }
            }
            sb.append(res).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
