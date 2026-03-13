import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' '))), m = Integer.parseInt(s.substring(s.indexOf(' ') + 1));

        Stack<int[]> stk = new Stack<>();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) if ((mat[i][j] = s.charAt(j)) == 'o') stk.push(new int[]{i, j});
        }

        while (!stk.isEmpty()) {
            int[] arr = stk.pop();
            int y = arr[0], x = arr[1];
            while (++y < n) if (mat[y][x] != '.') break;
            mat[arr[0]][x] = '.';
            mat[y - 1][x] = 'o';
        }

        for (int i = 0; i < n; i++, sb.append('\n')) for (int j = 0; j < m; j++) sb.append(mat[i][j]);

        bw.write(sb.toString());
        bw.flush();
    }

}
