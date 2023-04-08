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
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();

            int len = 0;
            for (int i = 0; i < t.length() && len != s.length(); i++) {
                if (s.charAt(len) == t.charAt(i))
                    len++;
            }

            sb.append(len == s.length() ? "Yes" : "No").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
