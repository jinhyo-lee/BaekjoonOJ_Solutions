import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = Integer.parseInt(br.readLine()), input = 0;
        while (sum <= 100 && br.ready())
            sum += input = Integer.parseInt(br.readLine());

        int prev = sum - input;
        if (Math.abs(100 - prev) < Math.abs(100 - sum))
            sum = prev;

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
