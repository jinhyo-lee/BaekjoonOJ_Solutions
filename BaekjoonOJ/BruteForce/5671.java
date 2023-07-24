import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] duplicate = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()) + 1;

            int cnt = 0;
            for (int i = n; i < m; i++, Arrays.fill(duplicate, false))
                if (check(i)) cnt++;

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean check(int num) {
        do {
            int tmp = num % 10;
            if (duplicate[tmp]) return false;
            duplicate[tmp] = true;
        } while ((num /= 10) > 0);

        return true;
    }

}
