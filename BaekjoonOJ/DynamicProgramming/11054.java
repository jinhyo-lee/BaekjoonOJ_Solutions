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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dpIn = new int[n];
        for (int i = 0; i < n; i++) {
            dpIn[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dpIn[i] < dpIn[j] + 1)
                    dpIn[i] = dpIn[j] + 1;
            }
        }

        int[] dpDe = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dpDe[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i] && dpDe[i] < dpDe[j] + 1)
                    dpDe[i] = dpDe[j] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dpIn[i] + dpDe[i]);

        bw.write(max - 1 + "\n");
        bw.flush();
    }

}
