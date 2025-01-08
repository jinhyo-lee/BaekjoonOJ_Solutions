import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] mat = new boolean[4][14];
        for (int i = 0; i < 51; i++) {
            int k = read();
            mat[k == 3 ? 0 : k == 2 ? 1 : k == 6 ? 2 : 3][read()] = true;
        }

        label:
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++) {
                if (mat[i][j]) continue;
                bw.write((i == 0 ? "S " : i == 1 ? "B " : i == 2 ? "V " : "K ") + j);
                break label;
            }
        }

        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
