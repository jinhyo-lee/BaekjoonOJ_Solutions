import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<String> lset = new LinkedHashSet<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            lset.remove(s);
            lset.add(s);
        }

        Set<String> set = new HashSet<>();
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) set.add(br.readLine());

        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        for (String s : lset) {
            if (set.contains(s)) a.add(s);
            else b.add(s);
        }

        for (int i = a.size() - 1; i >= 0; i--) sb.append(a.get(i)).append('\n');
        for (int i = b.size() - 1; i >= 0; i--) sb.append(b.get(i)).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

}
