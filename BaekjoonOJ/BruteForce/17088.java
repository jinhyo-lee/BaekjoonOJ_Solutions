import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write(0 + "\n");
            bw.flush();
            return;
        }

        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            input[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                arr = input.clone();
                cnt = 0;

                if (i != 0)
                    cnt++;
                if (j != 0)
                    cnt++;

                arr[0] += i;
                arr[1] += j;
                int gap = arr[1] - arr[0];

                if (check(gap))
                    min = Math.min(min, cnt);
            }
        }

        bw.write((min == Integer.MAX_VALUE ? -1 : min) + "\n");
        bw.flush();
    }

    private static boolean check(int gap) {
        for (int i = 2; i < n; i++) {
            int curGap = arr[i] - arr[i - 1];

            boolean flag = false;
            for (int j = -1; j <= 1; j++) {
                if (curGap + j == gap) {
                    if (j != 0)
                        cnt++;

                    arr[i] += j;
                    flag = true;

                    break;
                }
            }

            if (!flag)
                return false;
        }

        return true;
    }

}
