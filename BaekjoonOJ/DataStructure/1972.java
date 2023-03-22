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
        StringBuilder sb = new StringBuilder();

        String input;
        loop:
        while (!(input = br.readLine()).equals("*")) {
            for (int i = 1; i < input.length(); i++) {
                set.clear();
                for (int j = 0; j < input.length() - i; j++) {
                    String sub = String.valueOf(input.charAt(j)) + input.charAt(j + i);
                    if (!set.contains(sub))
                        set.add(sub);
                    else {
                        sb.append(input).append(" is NOT surprising.\n");
                        continue loop;
                    }
                }
            }
            sb.append(input).append(" is surprising.\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
