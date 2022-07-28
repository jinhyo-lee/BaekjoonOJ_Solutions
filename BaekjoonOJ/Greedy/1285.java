import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				if (input.charAt(j) == 'T')
					map[i][j] = 1;
			}
		}

		int res = n * n;
		for (int bit = 1; bit <= (1 << n); bit++) {
			int sum = 0;

			for (int x = 0; x < n; x++) {
				int tail = 0;

				for (int y = 0; y < n; y++) {
					int coin = map[y][x];

					if ((bit & (1 << y)) != 0)
						coin = map[y][x] ^ 1;
					if (coin == 1)
						tail++;
				}

				sum += Math.min(tail, n - tail);
			}

			if (sum < res)
				res = sum;
		}

		bw.write(res + "\n");
		bw.flush();
	}

}
