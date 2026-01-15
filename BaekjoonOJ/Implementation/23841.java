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

        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(" "))), m = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) mat[i] = br.readLine().toCharArray();
        for (int i = 0; i < n; i++, sb.append('\n'))
            for (int j = 0; j < m; j++) sb.append(mat[i][j] == '.' ? mat[i][m - j - 1] : mat[i][j]);

        bw.write(sb.toString());
        bw.flush();
    }

}
