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
            int cnt = 0, cont = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == 'O') cnt += ++cont;
                else cont = 0;
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
