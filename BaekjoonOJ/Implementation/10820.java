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

        String s;
        while ((s = br.readLine()) != null) {
            int l = 0, u = 0, n = 0, b = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') b++;
                else if (c < ':') n++;
                else if (c < '[') u++;
                else l++;
            }

            sb.append(l).append(" ").append(u).append(" ").append(n).append(" ").append(b).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
