import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        int sum = 0;

        br.readLine();
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                int i = Integer.parseInt(st.nextToken());
                if ((i & 1) == 0) sum += i;
                else list.add(i);
            }
        }

        list.sort(Comparator.reverseOrder());
        for (int i = 1; i < list.size(); i += 2) sum += list.get(i - 1) + list.get(i);

        bw.write(String.valueOf(sum / 2));
        bw.flush();
    }

}
