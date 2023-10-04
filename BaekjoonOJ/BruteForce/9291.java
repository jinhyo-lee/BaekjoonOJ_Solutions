import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int t = 1; t <= n; t++) {
            mat = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) mat[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }

            sb.append("Case ").append(t);
            if (isCorrect()) sb.append(": CORRECT\n");
            else sb.append(": INCORRECT\n");

            if (br.ready()) br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isCorrect() {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9], col = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (row[mat[i][j]]) return false;
                row[mat[i][j]] = true;

                if (col[mat[j][i]]) return false;
                col[mat[j][i]] = true;
            }
        }

        for (int y = 0; y < 7; y += 3) {
            for (int x = 0; x < 7; x += 3) {
                boolean[] sqr = new boolean[9];
                for (int i = y; i < y + 3; i++) {
                    for (int j = x; j < x + 3; j++) {
                        if (sqr[mat[i][j]]) return false;
                        sqr[mat[i][j]] = true;
                    }
                }
            }
        }

        return true;
    }

}
