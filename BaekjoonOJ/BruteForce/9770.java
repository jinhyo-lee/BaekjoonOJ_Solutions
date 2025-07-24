import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        String s;
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
        }

        int max = 0;
        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++) max = Math.max(max, gcd(list.get(i), list.get(j)));

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
