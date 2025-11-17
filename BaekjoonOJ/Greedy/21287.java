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

        boolean r = false, g = false, b = false;
        int n = Integer.parseInt(br.readLine());
        for (char c : br.readLine().toCharArray()) {
            if (c == 'R') r = true;
            else if (c == 'G') g = true;
            else b = true;

            if (r && g && b) {
                sb.append(c);
                r = false;
                g = false;
                b = false;
                if (--n == 0) break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
