import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> set = new LinkedHashSet<>();
        int k = Integer.parseInt(br.readLine()), n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            if (set.contains(s)) {
                set.remove(s);
                set.add(s);
            } else {
                set.add(s);
                if (set.size() > k) set.remove(set.iterator().next());
            }
        }

        List<String> list = new ArrayList<>(set);
        for (int i = list.size() - 1; i >= 0; i--) sb.append(list.get(i)).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
