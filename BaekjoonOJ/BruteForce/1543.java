import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String doc = br.readLine();
        String word = br.readLine();

        int cnt = 0;
        for (int i = 0; i < doc.length() - word.length() + 1; i++) {
            if (!doc.startsWith(word, i))
                continue;
            i += word.length() - 1;
            cnt++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
