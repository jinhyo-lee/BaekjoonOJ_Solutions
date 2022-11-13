import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 1000 - Integer.parseInt(br.readLine());
        int[] coins = {500, 100, 50, 10, 5, 1};

        int res = 0;
        for (int coin : coins) {
            if (n / coin != 0) {
                res += n / coin;
                n %= coin;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

}
