import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), sum = 0, cnt = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'O') sum += i + 1 + cnt++;
            else cnt = 0;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
