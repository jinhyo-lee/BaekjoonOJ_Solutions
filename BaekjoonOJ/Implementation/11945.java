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

        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' '))), m = Integer.parseInt(s.substring(s.indexOf(' ') + 1));
        s = br.readLine();
        for (int i = 0; i < n; i++, sb.append('\n'), s = br.readLine())
            for (int j = m - 1; j >= 0; j--) sb.append(s.charAt(j));

        bw.write(sb.toString());
        bw.flush();
    }

}
