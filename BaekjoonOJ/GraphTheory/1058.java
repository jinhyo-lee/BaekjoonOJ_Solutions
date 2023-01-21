import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < n; i++)
            arr[i] = br.readLine().toCharArray();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'Y') {
                    check[i][j] = true;
                    for (int k = 0; k < n; k++) {
                        if (arr[j][k] == 'Y')
                            check[i][k] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (i != j && check[i][j])
                    cnt++;
            }
            max = Math.max(max, cnt);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}
