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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            n--;
            for (int i = 0; i < n; i++) arr[i] = arr[i + 1] - arr[i];
        }

        for (int i = 0; i < n; i++) sb.append(arr[i]).append(',');

        bw.write(sb.deleteCharAt(sb.length() - 1).toString());
        bw.flush();
    }

}
