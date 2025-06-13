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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            boolean[] arr = new boolean[91];
            for (char c : br.readLine().toCharArray()) arr[c] = true;

            int sum = 0;
            for (int i = 65; i < 91; i++) if (!arr[i]) sum += i;
            sb.append(sum).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
