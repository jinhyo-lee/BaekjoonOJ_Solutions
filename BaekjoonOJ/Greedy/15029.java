import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {7, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 2, 0, 6, 4, 0, 0, 0, 0, 0, 5};
        int n = Integer.parseInt(br.readLine()), cnt = 0, max = 0, sum = 0;
        while (n-- > 0) {
            int i = arr[br.readLine().charAt(2) - 'a'];
            if (i == 1) cnt++;
            else {
                max = Math.max(max, i);
                sum += i;
            }
        }

        bw.write(sum > 0 ? String.valueOf(++max * cnt + sum) : "1");
        bw.flush();
    }

}
