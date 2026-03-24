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
            int i = Integer.parseInt(s.substring(0, s.indexOf(' ')));
            for (char c : s.substring(s.indexOf(' ') + 1).toCharArray()) if (--i != 0) sb.append(c);
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
