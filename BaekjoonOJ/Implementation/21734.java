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

        for (char c : br.readLine().toCharArray()) {
            int i = c, n = 0;
            do n += i % 10; while ((i /= 10) > 0);
            while (n-- > 0) sb.append(c);
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
