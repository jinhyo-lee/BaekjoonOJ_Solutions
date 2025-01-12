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

        bw.write(sum(Integer.parseInt(s.substring(0, s.length() / 2))) == sum(Integer.parseInt(s.substring(s.length() / 2))) ? "LUCKY" : "READY");
        bw.flush();
    }

    private static int sum(int n) {
        int sum = 0;
        do sum += n % 10; while ((n /= 10) > 0);

        return sum;
    }

}
