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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());

        char[][] mat = new char[r][c];
        for (int i = 0; i < r; i++) mat[i] = br.readLine().toCharArray();

        int[][] cache = new int[r][c];
        cache[0][0] = 1;
        for (int i = 1; i < r; i++)
            for (int j = 1; j < c; j++)
                for (int k = 0; k < i; k++)
                    for (int l = 0; l < j; l++) if (mat[i][j] != mat[k][l]) cache[i][j] += cache[k][l];

        bw.write(String.valueOf(cache[r - 1][c - 1]));
        bw.flush();
    }

}
