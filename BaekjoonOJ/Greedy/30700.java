import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = {'K', 'O', 'R', 'E', 'A'};
        int i = 0;
        for (char c : br.readLine().toCharArray()) if (s[i % 5] == c) i++;

        bw.write(String.valueOf(i));
        bw.flush();
    }

}
