import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int len, cnt;
    static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        len = s.length();

        for (int i = 0; i < len; i++)
            arr[s.charAt(i) - 'a']++;

        dfs(0, 0);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int prev, int depth) {
        if (depth == len) {
            cnt++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0 || (prev == i && depth != 0)) continue;

            arr[i]--;
            dfs(i, depth + 1);
            arr[i]++;
        }
    }

}
