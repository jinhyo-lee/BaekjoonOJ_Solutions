import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] n = new String[Integer.parseInt(br.readLine())], m = new String[Integer.parseInt(br.readLine())];
        for (int i = 0; i < n.length; i++) n[i] = br.readLine();
        for (int i = 0; i < m.length; i++) m[i] = br.readLine();

        for (String a : n) for (String b : m) sb.append(a).append(" as ").append(b).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
