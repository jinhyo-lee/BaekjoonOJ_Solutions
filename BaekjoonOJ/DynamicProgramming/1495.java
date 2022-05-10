import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int n, s, m;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		m = Integer.parseInt(input[2]);

		dp = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			dp[i] = -1;
		}

		dp[s] = 0;
		input = br.readLine().split(" ");

		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(input[i - 1]);
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j <= m; j++) {
				if (dp[j] == i - 1) {
					int up = j + v;
					int down = j - v;

					if (0 <= up && up <= m)
						list.add(up);
					if (0 <= down && down <= m)
						list.add(down);
				}
			}

			for (int n : list) {
				dp[n] = i;
			}
		}

		int max = -1;
		for (int i = 0; i <= m; i++) {
			if (dp[i] == n)
				max = Math.max(max, i);
		}

		bw.write(max + "\n");
		bw.flush();
	}

}
