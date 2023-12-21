import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String a = br.readLine(), b = br.readLine();

        int cnt = 0;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) == b.charAt(i)) cnt++;

        bw.write(String.valueOf(a.length() - Math.abs(k - cnt)));
        bw.flush();
    }

}
