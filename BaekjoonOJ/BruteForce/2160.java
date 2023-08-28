import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new char[n][5][7];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 5; j++) arr[i][j] = br.readLine().toCharArray();

        int min = 36, a = 0, b = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = compare(i, j);
                if (cnt < min) {
                    min = cnt;
                    a = i;
                    b = j;
                }
            }
        }

        bw.write((a + 1) + " " + (b + 1));
        bw.flush();
    }

    public static int compare(int a, int b) {
        int cnt = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 7; j++) if (arr[a][i][j] != arr[b][i][j]) cnt++;

        return cnt;
    }

}
