import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        mat = new char[n][n];

        for (int i = 0; i < n; i++) mat[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == '1') {
                    swap(i, j);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void swap(int y, int x) {
        for (int i = y; i >= 0; i--)
            for (int j = x; j >= 0; j--) mat[i][j] = mat[i][j] == '1' ? '0' : '1';
    }

}
