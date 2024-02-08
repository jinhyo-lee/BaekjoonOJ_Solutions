import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        sb.append(t).append("\n");

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (t-- > 0) {
            char[] arr = br.readLine().toCharArray();
            boolean[][] mat = new boolean[200][100];

            int cur = 0, y = 100, x = 0, top = 100, bot = 0, right = 0;
            mat[y][x] = true;
            for (char c : arr) {
                switch (c) {
                    case 'F':
                        y += dir[cur][0];
                        x += dir[cur][1];
                        break;
                    case 'R':
                        cur = (cur + 1) % 4;
                        y += dir[cur][0];
                        x += dir[cur][1];
                        break;
                    case 'B':
                        cur = (cur + 2) % 4;
                        y += dir[cur][0];
                        x += dir[cur][1];
                        break;
                    case 'L':
                        cur = (cur + 3) % 4;
                        y += dir[cur][0];
                        x += dir[cur][1];
                        break;
                }
                mat[y][x] = true;

                top = Math.min(top, y);
                bot = Math.max(bot, y);
                right = Math.max(right, x);
            }

            sb.append(++bot - --top + 1).append(" ").append(++right + 1).append("\n");
            for (int i = top; i <= bot; i++, sb.append('\n'))
                for (int j = 0; j <= right; j++) sb.append(mat[i][j] ? '.' : '#');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
