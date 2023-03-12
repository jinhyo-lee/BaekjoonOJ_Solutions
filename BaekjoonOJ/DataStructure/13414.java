import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();

        while (l-- > 0) {
            String input = br.readLine();
            if (set.contains(input))
                set.remove(input);

            set.add(input);
        }

        Iterator<String> it = set.iterator();
        StringBuilder sb = new StringBuilder();

        while (it.hasNext() && k-- > 0)
            sb.append(it.next()).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
