import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        mat = new boolean[n = Integer.parseInt(st.nextToken())][m = Integer.parseInt(st.nextToken())];
        for (int i = 0, j = 0; i < n; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[i][j++] = c == 'X';

        int r = 0, c = 0;
        for (int i = 0; i < n; i++) if (row(i)) r++;
        for (int i = 0; i < m; i++) if (col(i)) c++;

        bw.write(String.valueOf(Math.max(r, c)));
        bw.flush();
    }

    private static boolean row(int r) {
        for (int c = 0; c < m; c++) if (mat[r][c]) return false;
        return true;
    }

    private static boolean col(int c) {
        for (int r = 0; r < n; r++) if (mat[r][c]) return false;
        return true;
    }

}
