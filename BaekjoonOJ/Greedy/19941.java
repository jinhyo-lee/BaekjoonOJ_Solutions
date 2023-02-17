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

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int src = Math.max(i - k, 0);
            int dest = Math.min(i + k, n - 1);

            for (int j = src; j <= dest; j++) {
                if ((arr[i] == 'H' && arr[j] == 'P') || (arr[i] == 'P' && arr[i] == 'H')) {
                    arr[i] = '.';
                    arr[j] = '.';
                    cnt++;
                    break;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
