import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());

            Map<String, int[]> map = new HashMap<>();
            while (c-- > 0) {
                st = new StringTokenizer(br.readLine());
                String key = st.nextToken();
                int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                map.put(key, arr);
            }

            int fee = 100 / p;
            while (p-- > 0) {
                st = new StringTokenizer(br.readLine());
                sb.append(st.nextToken()).append(" ");

                char size = st.nextToken().charAt(0);
                int[] arr = map.get(st.nextToken());
                sb.append(round((size == 's' ? arr[0] : size == 'm' ? arr[1] : arr[2]) + fee)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int round(int n) {
        return n % 5 == 1 ? n - 1 : n % 5 == 4 ? n + 1 : n;
    }

}
