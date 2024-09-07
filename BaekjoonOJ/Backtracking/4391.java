import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int s, d, max;
    static int[] arr = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String in;
        while ((in = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            max = 0;

            recur(0, 0);
            sb.append(max > 0 ? max : "Deficit").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void recur(int i, int sum) {
        if (i > 4 && calc(i) >= 0) return;
        if (i == 12) {
            max = Math.max(max, sum);
            return;
        }

        if (max == 0) {
            arr[i] = s;
            recur(i + 1, sum + s);
            arr[i] = -d;
            recur(i + 1, sum - d);
        }
    }

    private static int calc(int i) {
        return arr[i - 5] + arr[i - 4] + arr[i - 3] + arr[i - 2] + arr[i - 1];
    }

}
