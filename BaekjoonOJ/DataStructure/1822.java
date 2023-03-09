import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        while (a-- > 0)
            set.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (b-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            if (set.contains(n))
                set.remove(n);
        }

        bw.write(set.size() + "\n");

        if (set.size() != 0) {
            for (int i : set)
                bw.write(i + " ");
        }

        bw.flush();
    }

}
