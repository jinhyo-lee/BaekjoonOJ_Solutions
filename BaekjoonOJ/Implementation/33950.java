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
            int n = s.length() - 1;
            for (int i = 0; i < n; i++) sb.append(s.charAt(i) == 'P' && s.charAt(i + 1) == 'O' ? "PH" : s.charAt(i));
            sb.append(s.charAt(n)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
