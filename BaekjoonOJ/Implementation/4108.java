import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    static boolean[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()).charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(s);
            mat = new boolean[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            for (int i = 0, j = 0; i < mat.length; i++, j = 0)
                for (char c : br.readLine().toCharArray()) mat[i][j++] = c == '*';

            for (int i = 0; i < mat.length; i++, sb.append('\n'))
                for (int j = 0; j < mat[0].length; j++) sb.append(mat[i][j] ? "*" : count(i, j));
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int count(int y, int x) {
        int cnt = 0;
        for (int[] d : dir) if (inRange(d[0] + y, d[1] + x) && mat[d[0] + y][d[1] + x]) cnt++;

        return cnt;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < mat.length && x >= 0 && x < mat[0].length;
    }

}
