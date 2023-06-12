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
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int low = 0, high = 1000000000;
        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int i : arr)
                if (i > mid) sum += i - mid;

            if (sum < m) high = mid - 1;
            else low = mid + 1;
        }

        bw.write(String.valueOf(high));
        bw.flush();
    }

}
