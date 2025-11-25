import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1, n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            String[] arr = new String[n + 1];
            for (int i = 1; i < arr.length; i++) arr[i] = br.readLine();

            boolean[] visit = new boolean[n + 1];
            n = n * 2 - 1;
            while (n-- > 0) {
                String s = br.readLine();
                int i = Integer.parseInt(s.substring(0, s.indexOf(' ')));
                visit[i] = !visit[i];
            }

            sb.append(t++).append(' ');
            for (int i = 1; i < arr.length; i++) {
                if (visit[i]) {
                    sb.append(arr[i]).append('\n');
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
