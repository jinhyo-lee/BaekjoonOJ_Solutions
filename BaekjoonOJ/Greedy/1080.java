import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		a = new int[n][m];
		int[][] b = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++)
				a[i][j] = input.charAt(j) - '0';
		}

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++)
				b[i][j] = input.charAt(j) - '0';
		}

		int cnt = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (a[i][j] != b[i][j]) {
					swap(i, j);
					cnt++;
				}
			}
		}
		
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					flag = false;
					break;
				}
			}
		}
		
		bw.write((flag ? cnt : -1) + "\n");
		bw.flush();
	}

	private static void swap(int y, int x) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++)
				a[i][j] = a[i][j] ^ 1;
		}
	}

}
