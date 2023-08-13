import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int key;
        while ((key = read()) != 0) {
            int low = 1, high = 50, mid;

            do {
                sb.append(mid = (low + high) >>> 1).append(" ");

                if (mid < key) low = mid + 1;
                else high = mid - 1;
            } while (mid != key);

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
