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

        int one = 0, two = 0, three = 0;
        while (n-- > 0) {
            String input = br.readLine();
            if (input.equals("1/4")) one++;
            else if (input.equals("1/2")) two++;
            else three++;
        }

        int cnt = 0, rest = 0;

        if (one > three) {
            cnt += three;
            rest += one - three;
        } else cnt += three;

        if (two % 2 != 0) rest += 2;
        cnt += two / 2;

        if (rest % 4 != 0) cnt++;
        cnt += rest / 4;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
