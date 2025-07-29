import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(parse(br.readLine())));
        bw.flush();
    }

    private static int parse(String x) {
        if (x.startsWith("0x")) return Integer.decode(x);
        else if (x.charAt(0) == '0') return Integer.parseInt(x, 8);
        else return Integer.parseInt(x);
    }

}
