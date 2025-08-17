import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            sb.append(new BigInteger(s.substring(0, i), 2).add(new BigInteger(s.substring(i + 1), 2)).toString(2)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
