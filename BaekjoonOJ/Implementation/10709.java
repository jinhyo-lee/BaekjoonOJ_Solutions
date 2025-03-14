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
        int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
        int[][] mat = new int[h][w];
        for (int i = 0, j = 0; i < h; i++, j = 0)
            for (char c : br.readLine().toCharArray()) mat[i][j++] = c == 'c' ? 0 : -1;

        for (int i = 0; i < h; i++) {
            for (int j = 0, k = -1; j < w; j++) {
                if (mat[i][j] == 0) k = j;
                else if (k != -1) mat[i][j] = j - k;
            }
        }

        for (int i = 0; i < h; i++, sb.append('\n')) for (int j = 0; j < w; j++) sb.append(mat[i][j]).append(' ');

        bw.write(sb.toString());
        bw.flush();
    }

}
