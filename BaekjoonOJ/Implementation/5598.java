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
        for (char c : br.readLine().toCharArray()) sb.append((c = (char) (c - 3)) < 'A' ? (char) (c + 26) : c);

        bw.write(sb.toString());
        bw.flush();
    }

}
