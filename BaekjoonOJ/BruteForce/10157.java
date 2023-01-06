import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int c, r, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        if (k > r * c)
            bw.write("0");
        else
            bw.write(find(r - 1, 0));

        bw.flush();
    }

    private static String find(int x, int y) {
        int idx = 0, dir = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visit = new boolean[r][c];

        while (++idx != k) {
            visit[x][y] = true;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny])
                dir = (dir + 1) % 4;

            x += dx[dir];
            y += dy[dir];
        }

        return (y + 1) + " " + (r - x);
    }

}
