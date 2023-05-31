import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String src = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (n-- > 0) {
            String tgt = br.readLine();
            if (tgt.concat(tgt).contains(src))
                cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
