import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		arr = new char[5][n / 5];
		for (int i = 0; i < 5; i++)
			arr[i] = str.substring(n / 5 * i, n / 5 * (i + 1)).toCharArray();

		for (int i = 0; i < n / 5; i++) {
			if (arr[0][i] == '#') {
				if (i + 2 <= n / 5 && arr[0][i + 1] == '#' && arr[0][i + 2] == '#') {
					bw.write(search(i) + "");
					i += 3;

					if (i >= n / 5)
						break;

					continue;
				}

				if (arr[3][i] == '#')
					bw.write(1 + "");
				else {
					bw.write(4 + "");
					i += 3;

					if (i >= n / 5)
						break;
				}
			}
		}

		bw.flush();
	}

	private static int search(int col) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) 
				sb.append(arr[i][j + col]);
		}

		return check(sb.toString());
	}

	private static int check(String signal) {
		String[] num = new String[10];
		
		num[0] = "####.##.##.####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";

		int result = 10;
		for (int i = 0; i < 10; i++) {
			if (signal.equals(num[i])) {
				result = i;
				break;
			}
		}

		return result;
	}

}
