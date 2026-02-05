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
        while (t-- > 0) sb.append(isFake(br.readLine()) ? "FAKE\n" : "OK\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isFake(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (++arr[s.charAt(i) - 'A'] == 3) {
                if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) return true;
                arr[s.charAt(i++) - 'A'] = 0;
            }
        }

        return false;
    }

}
