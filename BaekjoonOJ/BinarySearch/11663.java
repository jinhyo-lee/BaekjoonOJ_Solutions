import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int src = binarySearch(Integer.parseInt(st.nextToken()), true);
            sb.append(binarySearch(Integer.parseInt(st.nextToken()), false) - src).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(int key, boolean flag) {
        int left = 0, right = n - 1;

        if (flag) {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] < key) left = mid + 1;
                else right = mid - 1;
            }
        } else {
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > key) right = mid - 1;
                else left = mid + 1;
            }
        }

        return right;
    }

}
