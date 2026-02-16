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

        boolean[][] mat = new boolean[11][21];
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            mat[s.charAt(0) - 64][s.length() == 2 ? s.charAt(1) - 48 : (s.charAt(1) - 48) * 10 + (s.charAt(2) - 48)] = true;
        }

        for (int i = 1; i < 11; i++, sb.append('\n')) for (int j = 1; j < 21; j++) sb.append(mat[i][j] ? 'o' : '.');

        bw.write(sb.toString());
        bw.flush();
    }

}
