import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] hanoi = new int[13];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("1\n");

        int[] cache = new int[13];
        hanoi[1] = cache[1] = 1;

        recur(12);

        for (int i = 2; i <= 12; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) min = Math.min(min, cache[i - j] * 2 + hanoi[j]);
            sb.append(cache[i] = min).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int recur(int n) {
        if (n == 1) return 1;

        return hanoi[n] = recur(n - 1) * 2 + 1;
    }

}
