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

        Set<Character> set = new HashSet<>(Arrays.asList('R', 'A', 'K', 'T', 'S'));
        int n = Integer.parseInt(br.readLine()), i = 0, a = 0;
        String s = br.readLine();
        do set.remove(s.charAt(i)); while (i < n && ((a = s.charAt(i++) != 'A' ? a : a + 1) < 2 || !set.isEmpty()));

        bw.write(String.valueOf(i));
        bw.flush();
    }

}
