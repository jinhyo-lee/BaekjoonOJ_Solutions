import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int n;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = input.charAt(j) - '0';
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) 
					list.add(bfs(i, j));
			}
		}	
		bw.write(list.size() + "\n");
		
		Collections.sort(list);
		for (int i : list) 
			bw.write(i + "\n");
		
		bw.flush();
	}

	private static int bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(y, x));
		map[y][x] = 0;
		
		int cnt = 1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (ny < 0 || nx < 0 || ny >= n || nx >= n)
					continue;
				if (map[ny][nx] == 0)
					continue;

				q.offer(new Node(ny, nx));
				map[ny][nx] = 0;
				cnt++;
			}
		}

		return cnt;
	}

	private static class Node {
		int y;
		int x;

		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
