import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = read();
		while (t-- > 0) {
			int k = read() + 1;

			int[] sum = new int[k];
			for (int i = 1; i < k; i++) sum[i] = sum[i - 1] + read();

			int[][] dp = new int[k][k];
			for (int i = 1; i < k; i++) {
				for (int s = 1; s + i < k; s++) {
					int e = s + i;
					dp[s][e] = Integer.MAX_VALUE;
					for (int m = s; m < e; m++)
						dp[s][e] = Math.min(dp[s][e], dp[s][m] + dp[m + 1][e] + sum[e] - sum[s - 1]);
				}
			}

			sb.append(dp[1][k - 1]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}

	private static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

		return n;
	}

}
