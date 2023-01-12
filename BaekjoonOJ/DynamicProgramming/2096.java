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

        int[] max = new int[3];
        int[] min = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];
            for (int j = 0; j < 3; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            int left = max[0], right = max[2];
            max[0] = Math.max(max[0], max[1]) + arr[0];
            max[2] = Math.max(max[1], max[2]) + arr[2];
            max[1] = Math.max(Math.max(left, max[1]), right) + arr[1];

            left = min[0];
            right = min[2];
            min[0] = Math.min(min[0], min[1]) + arr[0];
            min[2] = Math.min(min[1], min[2]) + arr[2];
            min[1] = Math.min(Math.min(left, min[1]), right) + arr[1];
        }

        bw.write(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
        bw.flush();
    }

}
