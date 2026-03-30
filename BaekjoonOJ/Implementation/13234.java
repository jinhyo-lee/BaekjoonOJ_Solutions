import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int i = s.indexOf(' '), j = s.lastIndexOf(' ');
        boolean a = s.substring(0, i).charAt(0) == 't', b = s.substring(j + 1).charAt(0) == 't';

        bw.write(String.valueOf(s.substring(i + 1, j).charAt(0) == 'A' ? a && b : a || b));
        bw.flush();
    }

}
