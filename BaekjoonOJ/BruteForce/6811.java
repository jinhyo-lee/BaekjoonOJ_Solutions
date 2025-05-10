import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int a = read(), b = read(), c = read(), n = read(), A = n / a, B = n / b, C = n / c, cnt = 0;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k <= C; k++) {
                    int sum = i * a + j * b + k * c;
                    if (sum <= n && sum > 0) {
                        sb.append(i).append(" Brown Trout, ").append(j).append(" Northern Pike, ").append(k).append(" Yellow Pickerel\n");
                        cnt++;
                    }
                }
            }
        }

        bw.write(sb.append("Number of ways to catch fish: ").append(cnt).toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
