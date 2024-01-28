import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int n = 0, res = 0;
        while ((n += 2) <= s.length()) {
            for (int i = 0; i <= s.length() - n; i++) {
                if (isValid(s.substring(i, n + i))) {
                    res = n;
                    break;
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static boolean isValid(String sub) {
        int left = 0, right = 0, div = sub.length() / 2;

        for (int i = 0; i < div; i++) left += sub.charAt(i) - '0';
        for (int i = div; i < sub.length(); i++) right += sub.charAt(i) - '0';

        return left == right;
    }

}
