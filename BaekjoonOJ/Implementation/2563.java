import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];

		int cnt = 0;
		for (int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (arr[i][j] == 1)
						continue;
					arr[i][j] = 1;
					cnt++;
				}
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

}
