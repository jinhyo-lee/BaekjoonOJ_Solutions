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

		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++)
				cnt += Integer.parseInt(st.nextToken());

			if (cnt == 3)
				bw.write('A' + "\n");
			else if (cnt == 2)
				bw.write('B' + "\n");
			else if (cnt == 1)
				bw.write('C' + "\n");
			else if (cnt == 0)
				bw.write('D' + "\n");
			else
				bw.write('E' + "\n");
		}

		bw.flush();
	}

}
