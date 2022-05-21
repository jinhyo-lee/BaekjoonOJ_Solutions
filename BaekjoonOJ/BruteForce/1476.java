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

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 0;
		int s = 0;
		int m = 0;

		int year = 0;
		while (true) {
			if (e == 15)
				e = 0;
			if (s == 28)
				s = 0;
			if (m == 19)
				m = 0;

			e++;
			s++;
			m++;
			year++;

			if (e == E && s == S && m == M)
				break;
		}

		bw.write(year + "\n");
		bw.flush();
	}

}
