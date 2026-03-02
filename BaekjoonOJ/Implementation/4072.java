import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("#")) {
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                String w = st.nextToken();
                for (int i = w.length() - 1; i >= 0; i--) sb.append(w.charAt(i));
                sb.append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
