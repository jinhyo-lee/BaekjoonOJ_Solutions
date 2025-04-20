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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()), a = 0, b = 0;
            while (n-- > 0) {
                String s = br.readLine();
                int i = rps(s.charAt(0), s.charAt(2));
                if (i == 1) a++;
                else if (i == 2) b++;
            }
            sb.append(a > b ? "Player 1" : a < b ? "Player 2" : "TIE").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int rps(char a, char b) {
        if (a == b) return 0;
        else if ((a == 'R' && b == 'S') || (a == 'S' && b == 'P') || (a == 'P' && b == 'R')) return 1;

        return 2;
    }

}
