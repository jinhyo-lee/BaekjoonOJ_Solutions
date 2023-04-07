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

        long sum = 0;
        double max = 0;

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            long d = Long.parseLong(st.nextToken());
            sum += d;
            max = Math.max(max, d);
        }

        max = (max + sum) / 2;

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
