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

        String l = st.nextToken();
        String r = st.nextToken();

        int cnt = 0;
        if (l.length() == r.length()) {
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) != r.charAt(i))
                    break;
                if (l.charAt(i) == '8')
                    cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
