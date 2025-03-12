import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String s;
        while ((s = br.readLine()).charAt(0) != '=') calc(s.charAt(0), Integer.parseInt(br.readLine()));

        bw.write(String.valueOf(n));
        bw.flush();
    }

    private static void calc(char opt, int opr) {
        switch (opt) {
            case '+':
                n += opr;
                break;
            case '-':
                n -= opr;
                break;
            case '*':
                n *= opr;
                break;
            default:
                n /= opr;
        }
    }

}
