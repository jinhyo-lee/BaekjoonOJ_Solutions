import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int dir = 0, minY = 0, minX = 0, maxY = 0, maxX = 0, nowY = 0, nowX = 0;
			
			String command = br.readLine();
			for (int j = 0; j < command.length(); j++) {
				char c = command.charAt(j);

				if (c == 'F') {
					nowY = nowY + dy[dir];
					nowX = nowX + dx[dir];
				} else if (c == 'B') {
					nowY = nowY - dy[dir];
					nowX = nowX - dx[dir];
				} else if (c == 'L') {
					if (dir == 0)
						dir = 3;
					else
						dir--;
				} else if (c == 'R') {
					if (dir == 3)
						dir = 0;
					else
						dir++;
				}

				minY = Math.min(minY, nowY);
				minX = Math.min(minX, nowX);
				maxY = Math.max(maxY, nowY);
				maxX = Math.max(maxX, nowX);
			}
			
			sb.append((Math.abs(minY) + Math.abs(maxY)) * (Math.abs(minX) + Math.abs(maxX)) + "\n");
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
	}

}
