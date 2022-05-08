import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] rope = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			rope[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(rope);

		int max = 0;
		int w = 0;
		for (int i = n - 1; i >= 0; i--) {
			w = rope[i] * (n - i);
			max = Math.max(w, max);
		}

		bw.write(max + "\n");
		bw.flush();
	}

}
