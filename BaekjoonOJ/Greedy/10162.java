import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        if (t % 10 != 0)
            bw.write("-1");
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(t / 300 + " ");
            t %= 300;

            sb.append(t / 60 + " ");
            t %= 60;

            sb.append(t / 10 + " ");

            bw.write(sb.toString());
        }

        bw.flush();
    }

}
