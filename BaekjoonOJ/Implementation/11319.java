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

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int co = 0, vo = 0;
            for (char c : br.readLine().toLowerCase().toCharArray()) {
                if (c == ' ') continue;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vo++;
                else co++;
            }
            sb.append(co).append(' ').append(vo).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
