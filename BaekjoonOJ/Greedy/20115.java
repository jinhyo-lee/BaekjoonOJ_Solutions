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
        int max = 0;

        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int i = Integer.parseInt(st.nextToken());
            sum += i;
            max = Math.max(max, i);
        }

        bw.write(String.valueOf((max + sum) / 2d));
        bw.flush();
    }

}
