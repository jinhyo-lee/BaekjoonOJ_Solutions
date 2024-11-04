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
        String a = st.nextToken(), b = a.charAt(0) != '0' ? st.nextToken() : "0";

        bw.write(String.valueOf(sum(a) * sum(b)));
        bw.flush();
    }

    private static long sum(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';

        return sum;
    }

}
