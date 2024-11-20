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
            double n = Double.parseDouble(st.nextToken());
            while (st.hasMoreTokens()) {
                char c = st.nextToken().charAt(0);
                if (c == '@') n *= 3;
                else if (c == '%') n += 5;
                else n -= 7;
            }
            sb.append(String.format("%.2f\n", n));
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
