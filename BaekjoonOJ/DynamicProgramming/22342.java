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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int[][] mat = new int[m + 2][n];
        for (int i = 1; i <= m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) mat[i][j] = s.charAt(j) - '0';
        }

        int max = 0, tmp;
        for (int i = 1; i < n; i++)
            for (int j = 1; j <= m; j++, max = Math.max(max, tmp))
                mat[j][i] += tmp = Math.max(mat[j][i - 1], Math.max(mat[j + 1][i - 1], mat[j - 1][i - 1]));

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
