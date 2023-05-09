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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0, sum = 0;
        while (n-- > 0) {
            int input = Integer.parseInt(st.nextToken());

            max = Math.max(max, input);
            sum += input;
        }

        int cnt = max > sum - max ? max : (int) Math.ceil(sum / 2.0);

        bw.write(String.valueOf(cnt <= 1440 ? cnt : -1));
        bw.flush();
    }

}
