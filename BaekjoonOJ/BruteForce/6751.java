import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int y = read();
        do y++; while (isDistinct(y));

        bw.write(String.valueOf(y));
        bw.flush();
    }

    private static boolean isDistinct(int y) {
        boolean[] arr = new boolean[10];
        do {
            if (arr[y % 10]) return true;
            arr[y % 10] = true;
        } while ((y /= 10) > 0);

        return false;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
