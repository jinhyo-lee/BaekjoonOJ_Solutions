import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int b = read(), d = read(), c = read(), l = read();
        for (int i = 0; i < 251; i++)
            for (int j = 0; j < 251; j++)
                for (int k = 0; k < 251; k++)
                    if (b * i + d * j + c * k == l)
                        sb.append(i).append(' ').append(j).append(' ').append(k).append('\n');

        bw.write(sb.length() > 0 ? sb.toString() : "impossible");
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
