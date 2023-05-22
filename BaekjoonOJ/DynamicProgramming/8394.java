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

        int yes = 1, no = 0;
        while (n-- > 1) {
            int temp = no;
            no = yes;
            yes += temp % 10;
        }

        bw.write(String.valueOf((yes + no) % 10));
        bw.flush();
    }

}
