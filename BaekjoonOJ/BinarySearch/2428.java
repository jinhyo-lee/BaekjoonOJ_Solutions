import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0)
            arr[n] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long sum = 0;
        for (int i = 1; i < arr.length; i++)
            sum += binarySearch(arr[i] * 0.9, i);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static long binarySearch(double size, int i) {
        int left = 0, right = i - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < size) left = mid + 1;
            else right = mid - 1;
        }

        return i - left;
    }

}
