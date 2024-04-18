import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), cnt = 0;
        while (n-- > 0) if (isGroupWord(br.readLine())) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean isGroupWord(String s) {
        boolean[] arr = new boolean[26];
        int p = s.charAt(0) - 'a';
        arr[p] = true;

        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (c != p && arr[c]) return false;

            arr[c] = true;
            p = c;
        }

        return true;
    }

}
