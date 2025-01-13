import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), X = 0, Y = 0;
        boolean[][] mat = new boolean[n][n];
        for (int i = 0, j = 0; i < n; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[i][j++] = c == 'X';

        for (int i = 0; i < n; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j]) x = 0;
                else if (++x == 2) X++;

                if (mat[j][i]) y = 0;
                else if (++y == 2) Y++;
            }
        }

        bw.write(X + " " + Y);
        bw.flush();
    }

}
