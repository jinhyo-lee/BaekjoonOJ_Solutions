import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), x = 0, y = 0;
        while (n-- > 0 && Math.abs(x - y) < 2) {
            if (br.readLine().charAt(0) == 'D') x++;
            else y++;
        }

        bw.write(x + ":" + y);
        bw.flush();
    }

}
