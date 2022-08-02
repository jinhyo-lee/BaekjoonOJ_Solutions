import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[9][9];
	static List<Node> list = new ArrayList<>();
	static boolean flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Node(i, j));
			}
		}

		recur(0, 0);
		
		bw.write(sb + "\n");
		bw.flush();
	}

	private static void recur(int idx, int cnt) {
		if (cnt == list.size()) {
			flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) 
					sb.append(map[i][j] + " ");
				
				sb.append("\n");
			}
			
			return;
		}

		if (flag)
			return;

		int y = list.get(idx).y;
		int x = list.get(idx).x;

		for (int i = 1; i <= 9; i++) {
			if (check(y, x, i)) {
				map[y][x] = i;
				recur(idx + 1, cnt + 1);
				map[y][x] = 0;
			}
		}
	}

	private static boolean check(int y, int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[y][i] == num)
				return false;
			if (map[i][x] == num)
				return false;
		}

		int ny = y / 3 * 3;
		int nx = x / 3 * 3;

		for (int i = ny; i < ny + 3; i++) {
			for (int j = nx; j < nx + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

	private static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
