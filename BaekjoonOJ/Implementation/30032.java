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

        char[][] mat = {{'d', 'b', 'q', 'p'}, {'q', 'p', 'd', 'b'}, {'b', 'd', 'p', 'q'}};
        String s = br.readLine();
        int n = Integer.parseInt(s.substring(0, s.indexOf(' '))), d = Integer.parseInt(s.substring(s.indexOf(' ') + 1));
        while (n-- > 0) {
            for (char c : br.readLine().toCharArray()) {
                if (c == 'd') sb.append(mat[d][0]);
                else if (c == 'b') sb.append(mat[d][1]);
                else if (c == 'q') sb.append(mat[d][2]);
                else sb.append(mat[d][3]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
