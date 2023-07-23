import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) arr[n] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int idx = arr.length;
        while (idx > 0 && idx > arr[arr.length - idx]) idx--;

        bw.write(String.valueOf(idx));
        bw.flush();
    }

}
