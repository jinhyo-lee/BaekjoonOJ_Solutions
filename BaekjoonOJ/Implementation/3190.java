import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] board;
	static Map<Integer, String> comm = new HashMap<>();
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		board = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}

		int l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			comm.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		bw.write(dummy(0, 0, 0) + "\n");
		bw.flush();
	}

	private static int dummy(int y, int x, int dir) {
		List<int[]> snake = new LinkedList<>();
		snake.add(new int[] { 0, 0 });

		int sec = 0;
		while (true) {
			sec++;
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny < 0 || nx < 0 || ny >= n || nx >= n)
				break;

			for (int i = 0; i < snake.size(); i++) {
				if (ny == snake.get(i)[0] && nx == snake.get(i)[1])
					return sec;
			}

			if (board[ny][nx] == 1) {
				board[ny][nx] = 0;
				snake.add(new int[] { ny, nx });
			} else {
				snake.add(new int[] { ny, nx });
				snake.remove(0);
			}

			y = ny;
			x = nx;

			if (comm.containsKey(sec)) {
				if (comm.get(sec).equals("D")) {
					dir++;
					if (dir == 4)
						dir = 0;
				} else if (comm.get(sec).equals("L")) {
					dir--;
					if (dir == -1)
						dir = 3;
				}
			}
		}

		return sec;
	}

}
