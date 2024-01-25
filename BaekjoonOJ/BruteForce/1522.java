import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int range = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == 'a') range++;

        int min = 1000;
        for (int i = 0; i < s.length(); i++, range++) {
            int cnt = 0;
            for (int j = i; j < range; j++) if (s.charAt(j % s.length()) == 'b') cnt++;

            min = Math.min(min, cnt);
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

}
