import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[m + 1];
        for (int i = 1; i <= m; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Comparator.nullsFirst(Collections.reverseOrder()));

        int idx = 0, max = 0;
        for (int i = 1; i <= m && i <= n; i++) {
            if (arr[i] * i > max) {
                idx = i;
                max = arr[i] * i;
            }
        }

        bw.write(arr[idx] + " " + max);
        bw.flush();
    }

}
