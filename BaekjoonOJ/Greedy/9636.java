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
            int y = 0, x = 0, n = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == 'U') y++;
                else if (c == 'R') x++;
                else if (c == 'D') y--;
                else if (c == 'L') x--;
                else n++;
            }

            sb.append(x - n).append(" ").append(y - n).append(" ").append(x + n).append(" ").append(y + n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
