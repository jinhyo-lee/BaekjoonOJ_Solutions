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

        char[] arr;
        while ((arr = br.readLine().toLowerCase().toCharArray())[0] != '#') {
            int cnt = 0;
            for (char c : arr) if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
            sb.append(cnt).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
