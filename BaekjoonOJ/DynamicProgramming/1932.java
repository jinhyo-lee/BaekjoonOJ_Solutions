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
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++)
				arr[i - 1][j] = Math.max(arr[i - 1][j] + arr[i][j], arr[i - 1][j] + arr[i][j + 1]);
		}

		bw.write(arr[0][0] + "\n");
		bw.flush();
	}

}
