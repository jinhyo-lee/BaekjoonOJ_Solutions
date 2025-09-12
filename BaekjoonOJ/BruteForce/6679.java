import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i = 999, n;
        while (++i < 10000) if ((n = calc(i, 10)) == calc(i, 12) && n == calc(i, 16)) sb.append(i).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static int calc(int i, int base) {
        int sum = 0;
        do sum += i % base; while ((i /= base) > 0);

        return sum;
    }

}
