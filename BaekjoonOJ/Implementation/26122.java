import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine()), max = 0, prev = 0, cur = 1;
        char[] arr = br.readLine().toCharArray();
        for (int i = 1; i < k; i++) {
            if (arr[i - 1] == arr[i]) cur++;
            else {
                max = Math.max(max, Math.min(prev, cur) * 2);
                prev = cur;
                cur = 1;
            }
        }

        bw.write(String.valueOf(Math.max(max, Math.min(prev, cur) * 2)));
        bw.flush();
    }

}
