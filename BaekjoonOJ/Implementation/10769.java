import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = s.length() - 2, a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ':' && s.charAt(++i) == '-') {
                if (s.charAt(++i) == ')') a++;
                else if (s.charAt(i) == '(') b++;
                else i--;
            }
        }

        bw.write(a > b ? "happy" : a < b ? "sad" : a + b == 0 ? "none" : "unsure");
        bw.flush();
    }

}
