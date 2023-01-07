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
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        int[] arr = new int[l];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        if (n < arr[0])
            cnt = (arr[0] - n) * (n - 1) + (arr[0] - n - 1);
        else {
            int a, b;
            for (int i = 0; i < l; i++) {
                if (n == arr[i]) {
                    cnt = 0;
                    break;
                }
                if (arr[i] < n && arr[i + 1] > n) {
                    a = arr[i];
                    b = arr[i + 1];
                    cnt = (b - n) * (n - a - 1) + (b - n - 1);
                    break;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
