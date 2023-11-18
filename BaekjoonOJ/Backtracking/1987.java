import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int r, c, max;
    static char[][] mat;
    static boolean[] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if (r == 1 && c == 1) max = 1;
        else {
            mat = new char[r][c];
            visit = new boolean[26];
            for (int i = 0; i < r; i++) mat[i] = br.readLine().toCharArray();

            recur(0, 0, 0);
        }


        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static void recur(int y, int x, int cnt) {
        int idx = mat[y][x] - 'A';

        if (visit[idx]) {
            max = Math.max(max, cnt);
            return;
        }

        visit[idx] = true;
        for (int[] d : dir) {
            int ny = y + d[0], nx = x + d[1];
            if (ny >= 0 && ny < r && nx >= 0 && nx < c) recur(ny, nx, cnt + 1);
        }
        visit[idx] = false;
    }

}
