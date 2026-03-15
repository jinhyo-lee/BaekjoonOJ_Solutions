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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()), e = 0, o = 0;
            while (k-- > 0) {
                int i = Integer.parseInt(st.nextToken());
                if ((i & 1) == 0) e += i;
                else o += i;
            }
            sb.append(e > o ? "EVEN\n" : e < o ? "ODD\n" : "TIE\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
