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
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int pivot = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;

            if (input < 0)
                pivot++;
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < pivot; i += m)
            cnt += Math.abs(arr[i] * 2);

        for (int i = n - 1; i >= pivot; i -= m)
            cnt += arr[i] * 2;

        cnt -= Math.max(Math.abs(arr[0]), Math.abs(arr[n - 1]));

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
