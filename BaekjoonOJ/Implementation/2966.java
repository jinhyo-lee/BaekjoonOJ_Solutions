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

        char[][] mat = {{'A', 'B', 'C'}, {'B', 'A', 'B', 'C'}, {'C', 'C', 'A', 'A', 'B', 'B'}};
        int n = Integer.parseInt(br.readLine()), a = 0, b = 0, g = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == mat[0][i % 3]) a++;
            if (c == mat[1][i % 4]) b++;
            if (c == mat[2][i % 6]) g++;
        }

        int max = Math.max(a, Math.max(b, g));
        sb.append(max);
        if (max == a) sb.append("\nAdrian");
        if (max == b) sb.append("\nBruno");
        if (max == g) sb.append("\nGoran");

        bw.write(sb.toString());
        bw.flush();
    }

}
