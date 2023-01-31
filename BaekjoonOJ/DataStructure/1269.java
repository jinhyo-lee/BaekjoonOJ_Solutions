import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (a-- > 0)
            set.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while (b-- > 0) {
            int input = Integer.parseInt(st.nextToken());

            if (set.contains(input))
                set.remove(input);
            else
                set.add(input);
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }

}
