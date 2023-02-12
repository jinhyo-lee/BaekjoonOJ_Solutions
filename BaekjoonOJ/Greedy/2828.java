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

        st.nextToken();
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int res = 0, left = 1;
        while (j-- > 0) {
            int drop = Integer.parseInt(br.readLine());

            if (drop < left) {
                res += left - drop;
                left = drop;
            } else if (drop > left + m - 1) {
                res += drop - (left + m - 1);
                left = drop - m + 1;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

}
