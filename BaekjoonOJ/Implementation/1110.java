import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        int n = read(), cnt = 0;
        do {
            set.add(n);
            cnt++;
        } while (!set.contains(n = (n % 10) * 10 + (sum(n) % 10)));

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int sum(int n) {
        int sum = 0;
        do sum += n % 10; while ((n /= 10) > 0);

        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
