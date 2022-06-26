import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, l;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (check(i, 0, true))
				cnt++;
			if (check(0, i, false))
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static boolean check(int y, int x, boolean flag) {
		boolean[] visit = new boolean[n];
		int[] height = new int[n];

		for (int i = 0; i < n; i++)
			height[i] = flag ? map[y][i] : map[i][x];

		for (int i = 0; i < n - 1; i++) {
			if (height[i] == height[i + 1])
				continue;

			if (Math.abs(height[i] - height[i + 1]) > 1)
				return false;

			if (height[i] - height[i + 1] == 1) {
				for (int j = i + 1; j <= i + l; j++) {
					if (j >= n || height[i + 1] != height[j] || visit[j])
						return false;

					visit[j] = true;
				}
			} else if (height[i] - height[i + 1] == -1) {
				for (int j = i; j > i - l; j--) {
					if (j < 0 || height[i] != height[j] || visit[j])
						return false;

					visit[j] = true;
				}
			}
		}

		return true;
	}

}
