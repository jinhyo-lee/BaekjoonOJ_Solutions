import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] mat = new char[10][10];
        for (int i = 0; i < 10; i++) mat[i] = br.readLine().toCharArray();

        bw.write(find(mat) ? "1" : "0");
        bw.flush();
    }

    private static boolean find(char[][] mat) {
        for (int i = 0; i < 10; i++) {
            if (horizontal(mat, i) || vertical(mat, i)) return true;

            if (i > 5) continue;
            int n = 10 - i;
            if (diagonal(mat, 0, i, 1, n)) return true;
            if (i > 0 && diagonal(mat, i, 0, 1, n)) return true;

            if (diagonal(mat, 0, 9 - i, -1, n)) return true;
            if (i > 0 && diagonal(mat, i, 9, -1, n)) return true;
        }

        return false;
    }

    private static boolean diagonal(char[][] mat, int y, int x, int d, int n) {
        int scr = 0;
        for (int i = 0; i < 5; i++) scr += score(mat[y + i][x + i * d]);
        if (scr == 0) return true;

        for (int i = 5; i < n; i++) {
            scr -= score(mat[y + (i - 5)][x + (i - 5) * d]);
            scr += score(mat[y + i][x + i * d]);
            if (scr == 0) return true;
        }

        return false;
    }

    private static boolean horizontal(char[][] mat, int y) {
        int scr = 0;
        for (int i = 0; i < 5; i++) scr += score(mat[y][i]);
        if (scr == 0) return true;

        for (int i = 5; i < 10; i++) {
            scr -= score(mat[y][i - 5]);
            scr += score(mat[y][i]);
            if (scr == 0) return true;
        }

        return false;
    }

    private static boolean vertical(char[][] mat, int x) {
        int scr = 0;
        for (int i = 0; i < 5; i++) scr += score(mat[i][x]);
        if (scr == 0) return true;

        for (int i = 5; i < 10; i++) {
            scr -= score(mat[i - 5][x]);
            scr += score(mat[i][x]);
            if (scr == 0) return true;
        }

        return false;
    }

    private static int score(char c) {
        return c == 'X' ? 1 : c == '.' ? -4 : -10;
    }

}
