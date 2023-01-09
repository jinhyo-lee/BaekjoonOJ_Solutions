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

        int sum, a = 0, b = 1;
        for (int i = 1; i < k; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        bw.write(a + " " + b);
        bw.flush();
    }

}
