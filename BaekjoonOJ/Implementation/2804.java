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

        Pair p = new Pair(br.readLine());
        int[] loc = getLocation(p);

        for (int i = 0, k = 0; i < p.y; i++, sb.append('\n')) {
            if (i == loc[0]) {
                sb.append(p.a);
                k++;
            } else for (int j = 0; j < p.x; j++) sb.append(j == loc[1] ? p.b.charAt(k++) : '.');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] getLocation(Pair p) {
        for (int i = 0; i < p.x; i++)
            for (int j = 0; j < p.y; j++) if (p.a.charAt(i) == p.b.charAt(j)) return new int[]{j, i};

        return new int[]{0, 0};
    }

    private static class Pair {
        String a, b;
        int x, y;

        Pair(String s) {
            int i = s.indexOf(' ');
            this.a = s.substring(0, i);
            this.b = s.substring(i + 1);
            this.x = a.length();
            this.y = b.length();
        }
    }

}
