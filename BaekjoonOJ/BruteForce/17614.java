import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read(), cnt = 0;
        for (int i = 1; i <= n; i++) cnt += contains(i);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int contains(int i) {
        int mod, cnt = 0;
        do if ((mod = i % 10) == 3 || mod == 6 || mod == 9) cnt++; while ((i /= 10) > 0);

        return cnt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
