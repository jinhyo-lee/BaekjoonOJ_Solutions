import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (true) {
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            } else {
                n -= 3;
                cnt++;
            }

            if (n < 0) {
                cnt = -1;
                break;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
