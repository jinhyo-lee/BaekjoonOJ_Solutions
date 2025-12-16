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

        String s;
        while ((s = br.readLine()) != null) {
            int[] arr = new int[Integer.parseInt(s)];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int avg = 0;
            for (int i = 0; i < arr.length; i++) avg += arr[i] = Integer.parseInt(st.nextToken());

            if (avg % arr.length != 0) {
                sb.append("-1\n");
                continue;
            }

            avg = avg / arr.length;
            int sum = 0;
            for (int i : arr) sum += Math.abs(i - avg);
            sb.append(sum / 2 + 1).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
