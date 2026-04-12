import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = 200;
        String res = "", s;
        while ((s = br.readLine()) != null) {
            int i = s.indexOf(' '), n = Integer.parseInt(s.substring(i + 1));
            if (min <= n) continue;
            min = n;
            res = s.substring(0, i);
        }

        bw.write(res);
        bw.flush();
    }

}
