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
        for (int tc = 1; tc <= t; tc++) {
            int l = Integer.parseInt(br.readLine()), cnt = 0;
            String a = br.readLine(), b = br.readLine();
            for (int i = 0; i < l; i++) if (a.charAt(i) != b.charAt(i)) cnt++;
            sb.append("Case ").append(tc).append(": ").append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
