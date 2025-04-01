import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        mat = new boolean[n][n];
        for (int i = 0, j = 0; i < n; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[i][j++] = c == '*';

        int[] h = heart(), w = waist(h[0], h[1]);
        sb.append(h[0] + 1).append(' ').append(h[1] + 1).append('\n').append(arm(h[0], h[1], true)).append(' ').append(arm(h[0], h[1], false)).append(' ').append(w[0]).append(' ').append(reg(w[1], w[2] - 1)).append(' ').append(reg(w[1], w[2] + 1));

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] heart() {
        for (int i = 1; i < n - 2; i++)
            for (int j = 1; j < n - 1; j++)
                if (mat[i][j] && mat[i - 1][j] && mat[i][j + 1] && mat[i + 1][j] && mat[i][j - 1])
                    return new int[]{i, j};

        return new int[]{1, 1};
    }

    private static int[] waist(int i, int j) {
        int cnt = 0;
        while (mat[++i][j]) cnt++;

        return new int[]{cnt, i - 1, j};
    }

    private static int arm(int i, int j, boolean b) {
        int cnt = 0;
        if (b) while (--j >= 0 && mat[i][j]) cnt++;
        else while (++j < n && mat[i][j]) cnt++;

        return cnt;
    }

    private static int reg(int i, int j) {
        int cnt = 0;
        while (++i < n && mat[i][j]) cnt++;

        return cnt;
    }

}
