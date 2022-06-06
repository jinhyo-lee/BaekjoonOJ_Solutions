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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int loc = 0;
		int time = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			time += d - loc;
			loc = d;

			int state = time % (r + g);
			if (state < r)
				time += r - state;
		}

		time += l - loc;

		bw.write(time + "\n");
		bw.flush();
	}

}
