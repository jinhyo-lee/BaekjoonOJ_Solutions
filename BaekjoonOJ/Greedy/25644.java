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

        int n = Integer.parseInt(br.readLine());

        int max = 0, min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int input = Integer.parseInt(st.nextToken());

            max = Math.max(max, input - min);
            min = Math.min(min, input);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
