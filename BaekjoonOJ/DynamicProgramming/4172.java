import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[1000001];
        dp[0] = 1;

        for (double i = 1; i < dp.length; i++)
            dp[(int) i] = (dp[(int) (i - Math.sqrt(i))] + dp[(int) Math.log(i)] + dp[(int) (i * Math.pow(Math.sin(i), 2))]) % 1000000;

        int n;
        while ((n = read()) != -1) sb.append(dp[n]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;

        boolean flag = n == 13;
        if (flag) n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
