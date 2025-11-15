import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[10];
        for (int i = 0; i < 5; i++) arr[read()] = true;

        int min = 5;
        for (int i = 1; i < 6; i++) {
            int cnt = 0;
            for (int j = i + 4; j >= i; j--) if (!arr[j]) cnt++;
            min = Math.min(min, cnt);
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
