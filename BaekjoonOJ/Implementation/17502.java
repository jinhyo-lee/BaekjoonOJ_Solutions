import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), m = n / 2;
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i <= m; i++)
            arr[i] = arr[n - i - 1] = arr[i] != '?' ? arr[i] : arr[n - i - 1] != '?' ? arr[n - i - 1] : 'a';

        bw.write(String.valueOf(arr));
        bw.flush();
    }

}
