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
            String s = br.readLine();
            int cnt = 0;
            for (int i = s.length() - 1; i >= 0; i--) if (s.charAt(i) == 'a') cnt++;
            sb.append(Math.min(cnt, s.length() - cnt)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
