import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = new boolean[1000001];
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String x = br.readLine();
            if (x.charAt(0) == '-' || x.length() > 6) continue;
            arr[Integer.parseInt(x)] = true;
        }

        int i = -1;
        while (++i < arr.length) if (!arr[i]) break;

        bw.write(String.valueOf(i));
        bw.flush();
    }

}
