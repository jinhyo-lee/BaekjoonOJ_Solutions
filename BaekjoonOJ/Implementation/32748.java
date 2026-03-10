import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) arr[i] = read();

        int sum = 0, n = calc(read()) + calc(read()), m = 1;
        do {
            sum += arr[n % 10] * m;
            m *= 10;
        } while ((n /= 10) > 0);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int calc(int n) {
        int sum = 0, m = 1;
        do {
            for (int i = 0, j = n % 10; i < 10; i++) {
                if (arr[i] != j) continue;
                sum += i * m;
                m *= 10;
                break;
            }
        } while ((n /= 10) > 0);

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
