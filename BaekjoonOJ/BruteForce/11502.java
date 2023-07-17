import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int max;
    static boolean[] nonPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t];
        for (int i = 0; i < t; i++)
            max = Math.max(max, arr[i] = Integer.parseInt(br.readLine()));

        sieve();

        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(isThreePrime(i)).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static String isThreePrime(int n) {
        for (int i = n - 4; i > 1; i--) {
            if (nonPrime[i]) continue;
            int tmp = n - i;
            for (int j = tmp - 2; j > 1; j--) {
                if (nonPrime[j]) continue;
                if (!nonPrime[tmp - j]) return (tmp - j) + " " + j + " " + i;
            }
        }

        return "0";
    }

    private static void sieve() {
        max = max - 3;
        nonPrime = new boolean[max];
        nonPrime[0] = nonPrime[1] = true;

        for (int i = 2; i < max; i++) {
            if (!nonPrime[i]) {
                for (int j = i * i; j < max; j += i)
                    nonPrime[j] = true;
            }
        }
    }

}
