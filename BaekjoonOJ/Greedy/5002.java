import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());

        int m = 0, w = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == 'M') m++;
            else w++;

            if (Math.abs(m - w) > x) {
                if (c == 'M') m--;
                else w--;
                if (i == sb.length() - 1 || c == sb.charAt(i + 1)) break;
                else {
                    sb.setCharAt(i, sb.charAt(i + 1));
                    sb.setCharAt(i + 1, c);
                    i--;
                }
            }
        }

        bw.write(String.valueOf(m + w));
        bw.flush();
    }

}
