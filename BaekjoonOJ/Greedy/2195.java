import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String p = br.readLine();

        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (s.indexOf(p.substring(idx, i + 1)) != -1)
                continue;
            idx = i;
            cnt++;
        }

        bw.write(String.valueOf(cnt + 1));
        bw.flush();
    }

}
