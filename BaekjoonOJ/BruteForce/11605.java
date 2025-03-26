import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    static List<Function<Double, Double>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(getFunc(st.nextToken().charAt(0), Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;
        double d = 1;
        while (d < 101) if (calc(d++)) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean calc(double d) {
        for (Function<Double, Double> f : list) if ((d = f.apply(d)) < 0 || d % 1 != 0) return true;
        return false;
    }

    private static Function<Double, Double> getFunc(char c, int i) {
        if (c == 'A') return d -> d + i;
        else if (c == 'S') return d -> d - i;
        else if (c == 'M') return d -> d * i;
        else return d -> d / i;
    }

}
