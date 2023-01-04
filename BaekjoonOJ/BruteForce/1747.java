import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[] nonPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        sieve();

        while (true) {
            if (!nonPrime[n] && isPalindrome(String.valueOf(n))) {
                bw.write(String.valueOf(n));
                break;
            }
            n++;
        }

        bw.flush();
    }

    private static void sieve() {
        nonPrime = new boolean[1003002];
        nonPrime[1] = true;

        for (int i = 2; i < Math.sqrt(nonPrime.length); i++) {
            if (!nonPrime[i]) {
                for (int j = i * i; j < 1003002; j += i)
                    nonPrime[j] = true;
            }
        }
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }

        return true;
    }

}
