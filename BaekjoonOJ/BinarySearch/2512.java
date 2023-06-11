import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int m, left, right;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++)
            right = Math.max(right, arr[i] = Integer.parseInt(st.nextToken()));

        m = Integer.parseInt(br.readLine());
        while (left <= right)
            parametricSearch();

        bw.write(String.valueOf(right));
        bw.flush();
    }

    private static void parametricSearch() {
        int mid = (left + right) / 2;
        long budget = 0;
        for (int i : arr)
            budget += Math.min(i, mid);

        if (budget > m)
            right = mid - 1;
        else
            left = mid + 1;
    }

}
