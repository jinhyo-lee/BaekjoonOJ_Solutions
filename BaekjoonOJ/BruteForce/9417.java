import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

            int len = list.size() - 1, max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++)
                    max = Math.max(max, getGCD(list.get(i), list.get(j)));
            }
            list.clear();

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int getGCD(int a, int b) {
        if (a % b == 0) return b;

        return getGCD(b, a % b);
    }

}
