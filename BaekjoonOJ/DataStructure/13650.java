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

        String s;
        while ((s = br.readLine()) != null) {
            int[] arr = new int[61];
            int n = Integer.parseInt(s), cnt = 0;
            while (n-- > 0) {
                s = br.readLine();
                int m = Integer.parseInt(s.substring(0, 2));
                if (s.charAt(3) == 'D' ? arr[m]++ < 0 : arr[m]-- > 0) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
