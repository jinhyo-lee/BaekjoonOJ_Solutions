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
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean[] arr = new boolean[Integer.parseInt(st.nextToken())];

            String a = br.readLine();
            while (n-- > 0) {
                String b = br.readLine();
                for (int i = 0; i < arr.length; i++) if (a.charAt(i) == b.charAt(i)) arr[i] = true;
            }

            int cnt = 0;
            for (boolean b : arr) if (!b) cnt++;

            sb.append("Data Set ").append(tc).append(":\n").append(cnt).append('/').append(arr.length).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
