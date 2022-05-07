import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] t;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		t = new int[n + 1];
		p = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			cnt = Math.max(cnt, comp(i + t[i], p[i]));
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	private static int comp(int day, int pay) {
		if (day > n + 1)
			return 0;

		int temp = pay;
		for (int i = day; i <= n; i++) {
			temp = Math.max(temp, comp(i + t[i], pay + p[i]));
		}

		return temp;
	}
	
}
