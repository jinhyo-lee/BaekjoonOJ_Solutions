import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int cnt, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        while (n > 0)
            calculateFreq(n--);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void calculateFreq(int n) {
        do {
            if (n % 10 == d)
                cnt++;
        } while ((n /= 10) != 0);
    }

}
