import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long dp[][] = new long[n + 1][n + 1];
		dp[1][1] = 1;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val != 0) {
					if (i + val <= n)
						dp[i + val][j] += dp[i][j];
					if (j + val <= n)
						dp[i][j + val] += dp[i][j];
				}
			}
		}

		bw.write(dp[n][n] + "\n");
		bw.flush();
	}
	
}
