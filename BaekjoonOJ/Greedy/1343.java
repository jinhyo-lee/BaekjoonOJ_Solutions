import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        input = input.replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");

        if (input.contains("X"))
            bw.write("-1");
        else
            bw.write(input);

        bw.flush();
    }

}
