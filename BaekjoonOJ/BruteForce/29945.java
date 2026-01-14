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

        String[] arr = new String[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) arr[i] = br.readLine();

        String a = br.readLine();
        int cnt = 0;
        for (String b : arr) {
            if (!isMatch(a, b)) continue;
            sb.append(b).append('\n');
            cnt++;
        }

        bw.write(String.valueOf(cnt) + '\n' + sb);
        bw.flush();
    }

    private static boolean isMatch(String a, String b) {
        if (a.length() != b.length()) return false;

        int n = a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }

}
