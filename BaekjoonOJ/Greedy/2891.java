import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1);

        st = new StringTokenizer(br.readLine());
        while (s-- > 0) arr[Integer.parseInt(st.nextToken())]--;

        st = new StringTokenizer(br.readLine());
        while (r-- > 0) arr[Integer.parseInt(st.nextToken())]++;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 2) {
                if (arr[i - 1] == 0) arr[i - 1]++;
                else if (arr[i + 1] == 0) arr[i + 1]++;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++)
            if (arr[i] == 0) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
