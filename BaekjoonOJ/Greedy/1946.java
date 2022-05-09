import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] p = new int[n][2];
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				p[j][0] = Integer.parseInt(st.nextToken());
				p[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(p, Comparator.comparingInt(o1 -> o1[0]));

			int cnt = 1;
			int rank = p[0][1];
			for (int j = 1; j < n; j++) {
				if (p[j][1] < rank) {
					rank = p[j][1];
					cnt++;
				}
			}

			bw.write(cnt + "\n");
		}
		
		bw.flush();
	}

}
