import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] gear = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++)
				gear[i][j] = s.charAt(j) - '0';
		}

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			right(idx + 1, -dir);
			left(idx - 1, -dir);
			rotate(idx, dir);
		}

		int score = 0;
		for (int i = 0; i < 4; i++)
			score += gear[i][0] * (1 << i);

		bw.write(score + "\n");
		bw.flush();
	}

	private static void right(int idx, int dir) {
		if (idx > 3)
			return;

		if (gear[idx][6] != gear[idx - 1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}

	private static void left(int idx, int dir) {
		if (idx < 0)
			return;

		if (gear[idx][2] != gear[idx + 1][6]) {
			left(idx - 1, -dir);
			rotate(idx, dir);
		}
	}

	private static void rotate(int idx, int dir) {
		if (dir == 1) {
			int tmp = gear[idx][7];
			
			for (int i = 7; i > 0; i--)
				gear[idx][i] = gear[idx][i - 1];

			gear[idx][0] = tmp;
		} else {
			int tmp = gear[idx][0];
			
			for (int i = 0; i < 7; i++)
				gear[idx][i] = gear[idx][i + 1];
			
			gear[idx][7] = tmp;
		}
	}

}
