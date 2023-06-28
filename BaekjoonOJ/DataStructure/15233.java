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

        st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        br.readLine();

        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        while (b-- > 0) set.add(st.nextToken());

        int a = -1;
        st = new StringTokenizer(br.readLine());
        while (g-- > 0) {
            if (set.contains(st.nextToken())) b++;
            else a++;
        }

        bw.write(a == b ? "TIE" : a > b ? "A" : "B");
        bw.flush();
    }

}
