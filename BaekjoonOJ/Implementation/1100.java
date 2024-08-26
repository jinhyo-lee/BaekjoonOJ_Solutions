import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = i & 1; j < 8; j += 2) if (s.charAt(j) == 'F') cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
