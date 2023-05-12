import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(" " + br.readLine());

        int cnt = 0;
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == 'Y') {
                cnt++;
                for (int j = i; j < sb.length(); j += i)
                    sb.setCharAt(j, sb.charAt(j) == 'Y' ? 'N' : 'Y');
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
