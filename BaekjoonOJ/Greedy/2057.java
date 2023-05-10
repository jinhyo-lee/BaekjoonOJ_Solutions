import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        bw.write(n != 0 && isPossible(n) ? "YES" : "NO");
        bw.flush();
    }

    private static boolean isPossible(long n) {
        long fact = 2432902008176640000L;

        for (int i = 20; i > 0; i--) {
            fact /= i;
            if (n >= fact)
                n -= fact;
        }

        return n == 0;
    }

}
