import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        mat = new boolean[n][m];
        for (int i = 0, j = 0; i < n; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[i][j++] = c == '1';

        int cnt = 0;
        for (int i = 0; i < n; i++) for (int j = k - 1; j < m; j++) if (isPossible(i, j, k)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean isPossible(int i, int j, int k) {
        while (k-- > 0) if (mat[i][j - k]) return false;

        return true;
    }

}
