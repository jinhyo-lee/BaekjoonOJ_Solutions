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
		
		int[] val = new int[n];
		for (int i = 0; i < n; i++) {
			if (str[i] == 'B') {
				val[i] = 0;
			} else if (str[i] == 'O') {
				val[i] = 1;
			} else if (str[i] == 'J') {
				val[i] = 2;
			}
		}

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (val[j] != (val[i] + 2) % 3 || dp[j] == Integer.MAX_VALUE)
					continue;
				
				dp[i] = Math.min(dp[i], dp[j] + (int) Math.pow(i - j, 2));
			}
		}

		if (dp[n - 1] == Integer.MAX_VALUE) {
			bw.write(-1 + "\n");
		} else {
			bw.write(dp[n - 1] + "\n");
		}

		bw.flush();
	}

}
