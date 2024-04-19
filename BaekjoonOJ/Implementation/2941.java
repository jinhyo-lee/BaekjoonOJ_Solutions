import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(replace(br.readLine()).length()));
        bw.flush();
    }

    private static String replace(String s) {
        return s.replace("c=", " ").replace("c-", " ").replace("dz=", " ").replace("d-", " ").replace("lj", " ").replace("nj", " ").replace("s=", " ").replace("z=", " ");
    }

}
