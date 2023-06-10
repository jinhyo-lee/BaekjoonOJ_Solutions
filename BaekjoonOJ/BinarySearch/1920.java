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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (m-- > 0)
            bw.write(binarySearch(Integer.parseInt(st.nextToken())) + "\n");

        bw.flush();
    }

    private static int binarySearch(int key) {
        int low = 0, high = arr.length - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == key)
                return 1;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return 0;
    }

}
