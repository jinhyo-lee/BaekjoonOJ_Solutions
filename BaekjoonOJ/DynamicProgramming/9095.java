import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++)
			bw.write(sum(Integer.parseInt(br.readLine())) + "\n");

		bw.flush();
	}

	private static int sum(int n) {
		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < n + 1; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

		return dp[n];
	}

}
