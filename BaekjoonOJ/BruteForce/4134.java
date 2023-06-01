import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());

            if (n > 2) while (!isPrime(n)) n++;
            else n = 2;

            sb.append(n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPrime(long n) {
        double len = Math.sqrt(n);
        for (long i = 2; i <= len; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
