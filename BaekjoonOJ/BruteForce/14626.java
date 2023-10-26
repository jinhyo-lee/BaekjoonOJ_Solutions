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

        int idx = 0, sum = 0, c;
        for (int i = 0; i < 13; i++) {
            if ((c = s.charAt(i)) != '*') sum += i % 2 == 0 ? c - '0' : (c - '0') * 3;
            else idx = i;
        }

        int i;
        for (i = 0; i < 10; i++) {
            if (idx % 2 == 0 && (sum + i) % 10 == 0) break;
            else if (idx % 2 != 0 && (sum + 3 * i) % 10 == 0) break;
        }

        bw.write(String.valueOf(i));
        bw.flush();
    }

}
