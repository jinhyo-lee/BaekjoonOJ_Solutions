import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s;
        boolean b = br.readLine().compareTo(s = br.readLine()) < 0;
        while (n-- > 2) if (b != s.compareTo(s = br.readLine()) < 0) break;

        bw.write(n != 1 ? "NEITHER" : b ? "INCREASING" : "DECREASING");
        bw.flush();
    }

}
