import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] tri;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		tri = new int[45];
		for (int i = 1; i < 45; i++) {
			tri[i] = i * (i + 1) / 2;
		}

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			bw.write(match(num) + "\n");
		}

		bw.flush();
	}

	private static int match(int num) {
		for (int i = 1; i < 45; i++) {
			if (tri[i] > num)
				break;
			for (int j = 1; j < 45; j++) {
				if (tri[j] > num)
					break;
				for (int k = 1; k < 45; k++) {
					if (tri[k] > num)
						break;
					if (tri[i] + tri[j] + tri[k] == num)
						return 1;
				}
			}
		}

		return 0;
	}

}
