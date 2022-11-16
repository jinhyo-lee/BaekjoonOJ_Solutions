import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        StringTokenizer one = new StringTokenizer(s, "0");
        StringTokenizer zero = new StringTokenizer(s, "1");

        bw.write(String.valueOf(Math.min(one.countTokens(), zero.countTokens())));
        bw.flush();
    }

}
