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
        int cnt = 0;

        while (n-- > 0) {
            String input = br.readLine();
            if (!set.contains(input)) {
                StringBuilder sb = new StringBuilder(input);
                for (int i = 0; i < input.length(); i++)
                    set.add(sb.append(sb.charAt(0)).deleteCharAt(0).toString());
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
