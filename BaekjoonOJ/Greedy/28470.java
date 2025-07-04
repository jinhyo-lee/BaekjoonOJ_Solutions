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
        StringTokenizer A = new StringTokenizer(br.readLine()), B = new StringTokenizer(br.readLine()), K = new StringTokenizer(br.readLine());

        long sum = 0;
        while (n-- > 0) {
            int a = Integer.parseInt(A.nextToken()), b = Integer.parseInt(B.nextToken());
            float k = Float.parseFloat(K.nextToken());
            sum += k < 1 ? -(int) (k * 10 * b) / 10 + a : (int) (k * 10 * a) / 10 - b;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
