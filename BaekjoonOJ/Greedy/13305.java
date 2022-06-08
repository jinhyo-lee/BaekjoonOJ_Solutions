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
		long[] dist = new long[n - 1];
		long[] cost = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++)
			dist[i] = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			cost[i] = Long.parseLong(st.nextToken());

		long sum = 0;
		long min = cost[0];
		for (int i = 0; i < n - 1; i++) {
			if (cost[i] < min)
				min = cost[i];

			sum += min * dist[i];
		}

		bw.write(sum + "\n");
		bw.flush();
	}

}
