import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = br.readLine()) != null) {
            init();
            long n = Integer.parseInt(s);
            int k = 0;
            while (!set.isEmpty()) calc(n * ++k);
            sb.append(k).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void calc(long n) {
        do set.remove(n % 10); while ((n /= 10) > 0);
    }

    private static void init() {
        for (long i = 0; i < 10; i++) set.add(i);
    }

}
