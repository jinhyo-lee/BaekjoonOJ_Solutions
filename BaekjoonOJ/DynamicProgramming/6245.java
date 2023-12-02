import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] mat = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) mat[i][j] = convert(st.nextToken().charAt(0));
        }

        for (int i = 1; i < n; i++) {
            mat[i][0] += mat[i - 1][0];
            mat[0][i] += mat[0][i - 1];
        }

        for (int i = 1; i < n; i++) for (int j = 1; j < n; j++) mat[i][j] += Math.max(mat[i - 1][j], mat[i][j - 1]);

        bw.write(String.valueOf(mat[n - 1][n - 1]));
        bw.flush();
    }

    private static int convert(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            default:
                return c - '0';
        }
    }

}
