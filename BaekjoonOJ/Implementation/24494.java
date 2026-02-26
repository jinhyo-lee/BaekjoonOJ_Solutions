import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] a = new char[3][3], b = new char[3][3];
        for (int i = 0; i < 3; i++) a[i] = br.readLine().toCharArray();
        for (int i = 0; i < 3; i++) b[i] = br.readLine().toCharArray();

        int g = 0;
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (a[i][j] == b[i][j]) g++;

        int[] c = new int[26], d = new int[26];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == b[i][j]) continue;
                c[a[i][j] - 'A']++;
                d[b[i][j] - 'A']++;
            }
        }

        int y = 0;
        for (int i = 0; i < 26; i++) y += Math.min(c[i], d[i]);

        bw.write(g + "\n" + y);
        bw.flush();
    }

}
