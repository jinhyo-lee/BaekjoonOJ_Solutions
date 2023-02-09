import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = Long.parseLong(br.readLine());

        long sum = 0;
        int cnt = 0;

        while (s >= sum)
            sum += ++cnt;

        bw.write(String.valueOf(sum != s ? cnt - 1 : cnt));
        bw.flush();
    }

}
