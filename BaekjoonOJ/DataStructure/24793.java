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

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        String s = br.readLine();
        set.add(s);
        char c = s.charAt(s.length() - 1);

        int i = 2;
        while (!set.contains(s = br.readLine()) && c == s.charAt(0) && i++ < n) {
            set.add(s);
            c = s.charAt(s.length() - 1);
        }

        bw.write(i == n + 1 ? "Fair Game" : "Player " + (2 - i % 2) + " lost");
        bw.flush();
    }

}
