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
        int n = s.length();

        bw.write(n > 4 && s.charAt(n - 5) == 'd' && s.charAt(n - 4) == 'r' && s.charAt(n - 3) == 'i' && s.charAt(n - 2) == 'i' && s.charAt(n - 1) == 'p' ? "cute" : "not cute");
        bw.flush();
    }

}
