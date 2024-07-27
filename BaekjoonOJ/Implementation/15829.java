import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int l = Integer.parseInt(br.readLine()), m = 1234567891;
        String s = br.readLine();

        long h = 0, r = 1;
        for (int i = 0; i < l; i++, r = r * 31 % m) h += (s.charAt(i) - 96) * r;

        bw.write(String.valueOf(h % m));
        bw.flush();
    }

}
