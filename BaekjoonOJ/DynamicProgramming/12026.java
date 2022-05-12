import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		int[] dp = new int[n];
		
		final int max = 987654321;
		Arrays.fill(dp, max);
		dp[0] = 0;

		for (int i = 0; i < n - 1; i++) {
			if (str[i] == 'B') {
				for (int j = i + 1; j < n; j++) {
					if (str[j] == 'O') {
						dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
					}
				}
			} else if (str[i] == 'O') {
				for (int j = i + 1; j < n; j++) {
					if (str[j] == 'J') {
						dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
					}
				}
			} else {
				for (int j = i + 1; j < n; j++) {
					if (str[j] == 'B') {
						dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
					}
				}
			}
		}

		if (dp[n - 1] == max) {
			bw.write(-1 + "\n");

		} else {
			bw.write(dp[n - 1] + "\n");
		}

		bw.flush();
	}

}
