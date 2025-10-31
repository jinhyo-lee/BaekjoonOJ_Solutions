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
            String s = br.readLine();
            sb.append(s);
            int g = 0, b = 0;
            for (char c : s.toLowerCase().toCharArray()) {
                if (c == 'g') g++;
                else if (c == 'b') b++;
            }
            sb.append(g == b ? " is NEUTRAL\n" : g > b ? " is GOOD\n" : " is A BADDY\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
