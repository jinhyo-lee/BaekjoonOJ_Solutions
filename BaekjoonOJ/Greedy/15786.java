import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), m = read();
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        loop:
        while (m-- > 0) {
            int i = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == s.charAt(i)) {
                    if (++i == n) {
                        sb.append("true\n");
                        continue loop;
                    }
                }
            }
            sb.append("false\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
