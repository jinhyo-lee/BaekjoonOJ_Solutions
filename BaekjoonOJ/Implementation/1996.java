import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int[][] mat, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) if (s.charAt(j) != '.') mark(i, j, s.charAt(j) - '0');
        }

        for (int i = 0; i < n; i++, sb.append('\n')) for (int j = 0; j < n; j++) append(sb, mat[i][j]);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void mark(int y, int x, int i) {
        mat[y][x] = -1;
        for (int[] d : dir) {
            int ny = y + d[0], nx = x + d[1];
            if (inRange(ny, nx) && mat[ny][nx] != -1) mat[ny][nx] += i;
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < mat.length && x >= 0 && x < mat[0].length;
    }

    private static void append(StringBuilder sb, int i) {
        if (i == -1) sb.append('*');
        else if (i > 9) sb.append('M');
        else sb.append(i);
    }

}
