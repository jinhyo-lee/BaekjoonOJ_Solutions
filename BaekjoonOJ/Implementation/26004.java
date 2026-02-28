import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < n; i++) arr[s.charAt(i) - 'A']++;

        bw.write(String.valueOf(Math.min(arr[7], Math.min(arr[8], Math.min(arr[0], Math.min(arr[17], arr[2]))))));
        bw.flush();
    }

}
