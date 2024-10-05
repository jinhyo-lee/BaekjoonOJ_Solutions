import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        String s = br.readLine();
        for (int i = s.length() - n; i >= 0; i--) set.add(s.substring(i, n + i));

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

}
