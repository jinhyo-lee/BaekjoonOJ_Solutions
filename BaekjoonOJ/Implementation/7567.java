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
        int sum = 10;
        for (int i = 1; i < s.length(); i++) sum += s.charAt(i - 1) == s.charAt(i) ? 5 : 10;

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
