import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = read();
        mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) mat[i][j] = read();

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (isNeighbor(i, j)) sb.append(i + 1).append(" ").append(j + 1).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isNeighbor(int src, int tgt) {
        for (int i = 0; i < mat.length; i++) {
            if (src == i || tgt == i) continue;
            if (mat[src][tgt] == mat[src][i] + mat[i][tgt]) return false;
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
