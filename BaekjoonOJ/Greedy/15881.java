import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()) - 3;
        String s = br.readLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.startsWith("pPAp", i)) {
                cnt++;
                i += 3;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
