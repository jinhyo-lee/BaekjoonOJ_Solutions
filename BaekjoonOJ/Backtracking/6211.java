import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        arr = new int[b];

        st = new StringTokenizer(br.readLine());
        while (b-- > 0)
            arr[b] = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(recur(0, 0)));
        bw.flush();
    }

    private static int recur(int sum, int idx) {
        if (sum > c)
            return -1;

        if (idx == arr.length)
            return sum;

        return Math.max(recur(sum + arr[idx], idx + 1), recur(sum, idx + 1));
    }

}
