import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            int n = read(), m = read();
            Price[] prices = new Price[n];

            for (int i = 0; i < n; i++) {
                int k = read();
                List<Integer> list = new ArrayList<>();

                while (k-- > 0) list.add(read());
                prices[i] = new Price(read(), list);
            }

            int[] cnt = new int[m + 1];
            for (int i = 1; i <= m; i++) cnt[i] = read();

            int sum = 0;
            label:
            for (Price price : prices) {
                int min = Integer.MAX_VALUE;
                for (int i : price.list) {
                    if (cnt[i] < 1) continue label;
                    min = Math.min(min, cnt[i]);
                }

                sum += price.price * min;
            }

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Price {
        int price;
        List<Integer> list;

        Price(int price, List<Integer> list) {
            this.price = price;
            this.list = list;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
