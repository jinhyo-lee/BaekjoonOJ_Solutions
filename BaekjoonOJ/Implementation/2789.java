import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>(Arrays.asList('C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'));
        for (char c : br.readLine().toCharArray()) if (!set.contains(c)) sb.append(c);

        bw.write(sb.toString());
        bw.flush();
    }

}
