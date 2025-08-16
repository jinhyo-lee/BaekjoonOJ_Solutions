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

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            int i = getIndex(s);
            sb.append(s, i + 1, s.length()).append(' ').append(s, 0, i).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int getIndex(String s) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (flag && s.charAt(i) == ' ') return i;
            else if (s.charAt(i) == ' ') flag = true;
        }

        return -1;
    }

}
