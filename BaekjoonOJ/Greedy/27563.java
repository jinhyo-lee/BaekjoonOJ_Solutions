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

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String s = br.readLine();

            if (s.length() < 3 || !s.substring(1, s.length() - 1).contains("O")) sb.append("-1");
            else if (s.contains("MOO")) sb.append(s.length() - 3);
            else if (s.contains("MOM") || s.contains("OOO")) sb.append(s.length() - 2);
            else if (s.contains("OOM")) sb.append(s.length() - 1);

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
