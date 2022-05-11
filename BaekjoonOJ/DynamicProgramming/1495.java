import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] dp = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			dp[i] = -1;
		}

		dp[s] = 0;
		String[] input = br.readLine().split(" ");

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

			for (int j : list) {
				dp[j] = i;
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
