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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        while (n-- > 0)
            arr[n] = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 1; i < arr.length - 1; i++)
            max = Math.max(max, arr[i] + Math.min(arr[i - 1], arr[i + 1]));

        bw.write(String.valueOf(Math.max(max, Math.max(arr[0], arr[arr.length - 1]))));
        bw.flush();
    }

}
