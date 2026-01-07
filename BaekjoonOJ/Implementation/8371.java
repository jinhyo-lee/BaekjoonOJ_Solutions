import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), cnt = 0;
        String a = br.readLine(), b = br.readLine();
        for (int i = 0; i < n; i++) if (a.charAt(i) != b.charAt(i)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
