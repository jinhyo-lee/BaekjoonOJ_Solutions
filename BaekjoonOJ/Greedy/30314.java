import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), sum = 0;
        String a = br.readLine(), b = br.readLine();
        while (n-- > 0) sum += calc(a.charAt(n) - 'A', b.charAt(n) - 'A');

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    private static int calc(int a, int b) {
        return Math.min(Math.abs(a - b), 26 - Math.abs(a - b));
    }

}
