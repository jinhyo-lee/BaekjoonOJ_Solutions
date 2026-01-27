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

        br.readLine();
        int b = 0, s = 0, a = 0;
        for (char c : br.readLine().toCharArray()) {
            if (c == 'B') b++;
            else if (c == 'S') s++;
            else a++;
        }

        int max = Math.max(Math.max(b, s), a);
        if (max == b) sb.append('B');
        if (max == s) sb.append('S');
        if (max == a) sb.append('A');

        bw.write(sb.length() == 3 ? "SCU" : sb.toString());
        bw.flush();
    }

}
