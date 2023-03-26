import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        String input;

        while ((input = br.readLine()) != null)
            list.add(Integer.parseInt(input));

        BigInteger[] dp = new BigInteger[Collections.max(list) + 1];

        if (dp.length > 1)
            dp[0] = dp[1] = BigInteger.valueOf(1);

        for (int i = 2; i < dp.length; i++)
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));

        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(dp[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

}
