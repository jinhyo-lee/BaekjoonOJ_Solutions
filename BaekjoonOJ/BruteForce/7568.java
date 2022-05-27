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
		int[][] build = new int[n][2];
		int[] rank = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			build[i][0] = Integer.parseInt(st.nextToken());
			build[i][1] = Integer.parseInt(st.nextToken());
			rank[i]++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (build[i][0] < build[j][0] && build[i][1] < build[j][1])
					rank[i]++;
			}
		}

		for (int i : rank) {
			bw.write(i + " ");
		}

		bw.flush();
	}

}
