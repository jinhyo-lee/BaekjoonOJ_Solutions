import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n, m;
    static char[][] arr;
    static int[] dy = {-1, -1, 0, 0, 1, 1}, dxe = {-1, 0, -1, 1, -1, 0}, dxo = {0, 1, -1, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        m = read();

        arr = new char[n][m];
        for (int i = 0; i < n; i++) arr[i] = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (arr[i][j] == '#') cnt += count(i, j);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int count(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            int ny = y + dy[i], nx = x + (y % 2 == 0 ? dxe[i] : dxo[i]);

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            if (arr[ny][nx] == '.') cnt++;
        }

        return cnt;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
