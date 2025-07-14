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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            char c = s.charAt(0);
            if (c == ']' || (c >= '0' && c <= '9')) sum += 8;
            else if (c != '[') sum += s.length() + 12;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
