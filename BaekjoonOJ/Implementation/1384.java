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

        int n, g = 0;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[] arr = new String[n];
            boolean[][] mat = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken();
                for (int j = 1; j < n; j++) mat[i][j] = st.nextToken().charAt(0) == 'N';
            }

            sb.append("Group ").append(++g).append('\n');
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < n; i++)
                for (int j = 1; j < n; j++)
                    if (mat[i][j])
                        tmp.append(arr[(i - j + n) % n]).append(" was nasty about ").append(arr[i]).append('\n');
            sb.append(tmp.length() > 0 ? tmp.append('\n') : "Nobody was nasty\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
