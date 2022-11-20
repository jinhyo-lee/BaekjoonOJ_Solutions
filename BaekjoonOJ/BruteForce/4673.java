import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] check = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int num = d(i);
            if (num <= 10000)
                check[num] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!check[i])
                bw.write(i + "\n");
        }

        bw.flush();
    }

    private static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

}
