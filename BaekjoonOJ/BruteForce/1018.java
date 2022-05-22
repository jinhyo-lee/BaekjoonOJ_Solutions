import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] arr;
	static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}

		int row = n - 7;
		int col = m - 7;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				match(i, j);
			}
		}

		bw.write(min + "\n");
		bw.flush();
	}

	private static void match(int y, int x) {
		int Y = y + 8;
		int X = x + 8;
		boolean chk = arr[y][x];
		
		int cnt = 0;
		for (int i = y; i < Y; i++) {
			for (int j = x; j < X; j++) {
				if (chk != arr[i][j])
					cnt++;

				chk = (!chk);
			}
			chk = !chk;
		}
		

		min = Math.min(min, Math.min(cnt, 64 - cnt));
	}

}
