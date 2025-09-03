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
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>();
        String s;
        while ((s = br.readLine()).charAt(0) != '#') {
            for (char c : s.toLowerCase().toCharArray()) if (Character.isAlphabetic(c)) set.add(c);
            sb.append(set.size()).append('\n');
            set.clear();
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

}
