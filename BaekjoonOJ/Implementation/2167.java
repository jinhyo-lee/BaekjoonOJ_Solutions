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
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1, m = Integer.parseInt(st.nextToken()) + 1;
        int[][] mat = new int[n][m];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m; j++)
                mat[i][j] = Integer.parseInt(st.nextToken()) + mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1];
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()), j = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            sb.append(mat[x][y] - mat[i - 1][y] - mat[x][j - 1] + mat[i - 1][j - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
