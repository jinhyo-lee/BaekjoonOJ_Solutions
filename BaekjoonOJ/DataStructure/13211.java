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

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) set.add(br.readLine());

        int m = Integer.parseInt(br.readLine()), cnt = 0;
        while (m-- > 0) if (set.contains(br.readLine())) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
