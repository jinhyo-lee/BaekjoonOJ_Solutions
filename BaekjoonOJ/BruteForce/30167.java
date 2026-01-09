import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = read(), r = read();
        do if (isDistinct(l)) break; while (l++ < r);

        bw.write(l > r ? "-1" : String.valueOf(l));
        bw.flush();
    }

    private static boolean isDistinct(int i) {
        int[] arr = new int[10];
        arr[i % 10]++;
        while ((i /= 10) > 0) if (++arr[i % 10] == 2) return false;

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
