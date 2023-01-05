import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            int tmp = 1, idx = 1;
            while ((tmp = tmp % n) != 0) {
                tmp = tmp * 10 + 1;
                idx++;
            }

            bw.write(idx + "\n");
            if (!br.ready())
                break;
        }

        bw.flush();
    }

}
