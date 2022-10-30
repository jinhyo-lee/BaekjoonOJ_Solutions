import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            arr[src][dest] = -1;
            arr[dest][src] = 1;
        }

        floydWarshall();

        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
        }

        bw.flush();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] == 0) {
                        if (arr[i][k] == 1 && arr[k][j] == 1)
                            arr[i][j] = 1;
                        else if (arr[i][k] == -1 && arr[k][j] == -1)
                            arr[i][j] = -1;
                    }
                }
            }
        }
    }

}
