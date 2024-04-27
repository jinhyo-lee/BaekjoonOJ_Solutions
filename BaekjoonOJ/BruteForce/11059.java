import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine();

        bw.write(String.valueOf(find()));
        bw.flush();
    }

    private static int find() {
        for (int i = s.length() - (s.length() & 1); i > 0; i -= 2)
            for (int j = i; j <= s.length(); j++)
                if (sum(j - i, j - 1) == 0) return i;

        return 0;
    }

    private static int sum(int h, int t) {
        int sum = 0;
        while (h < t) sum += s.charAt(h++) - s.charAt(t--);

        return sum;
    }

}
