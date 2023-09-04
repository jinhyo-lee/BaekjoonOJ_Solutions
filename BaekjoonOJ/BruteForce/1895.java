import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) mat[i][j] = Integer.parseInt(st.nextToken());
        }

        int t = Integer.parseInt(br.readLine()), cnt = 0;
        for (int i = 0; i < r - 2; i++) for (int j = 0; j < c - 2; j++) if (t <= getMedian(i, j)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int getMedian(int y, int x) {
        int[] arr = new int[9];

        int idx = 0;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) arr[idx++] = mat[i + y][j + x];

        Arrays.sort(arr);
        return arr[4];
    }

}
