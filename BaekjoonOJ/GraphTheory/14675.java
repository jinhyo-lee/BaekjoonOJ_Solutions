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

        int[] arr = new int[n + 1];
        while (n-- > 1) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sb.append(t == 2 ? "yes" : arr[k] > 1 ? "yes" : "no").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
