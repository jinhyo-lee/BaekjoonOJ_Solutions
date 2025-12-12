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
            int m = Integer.parseInt(br.readLine()), max = 0;
            String s = "";
            while (m-- > 0) {
                Pair p = new Pair(br.readLine());
                if (max < p.c) {
                    max = p.c;
                    s = p.s;
                }
            }
            sb.append(s).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair {
        int c;
        String s;

        Pair(String s) {
            int i = s.indexOf(' ');
            this.c = Integer.parseInt(s.substring(0, i));
            this.s = s.substring(i + 1);
        }
    }

}
