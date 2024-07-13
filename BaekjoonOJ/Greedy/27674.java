import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            String s = br.readLine();
            int[] arr = new int[s.length()];
            for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i) - '0';

            Arrays.sort(arr);

            long a = arr[0], b = arr[1], mul = 1;
            for (int i = 2; i < arr.length; i++) b += arr[i] * (mul *= 10);

            sb.append(a + b).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
