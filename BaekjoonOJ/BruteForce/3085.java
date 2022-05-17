import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static int n;
	public static char[][] box;
	public static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		box = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			box[i] = line.toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				char swap = box[i][j];
				box[i][j] = box[i][j + 1];
				box[i][j + 1] = swap;

				search();

				swap = box[i][j];
				box[i][j] = box[i][j + 1];
				box[i][j + 1] = swap;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				char swap = box[j][i];
				box[j][i] = box[j + 1][i];
				box[j + 1][i] = swap;

				max = Math.max(search(), max);

				swap = box[j][i];
				box[j][i] = box[j + 1][i];
				box[j + 1][i] = swap;
			}
		}

		bw.write(max + "\n");
		bw.flush();
	}

	private static int search() {
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (box[i][j] == box[i][j + 1]) {
					cnt++;
				} else {
					cnt = 1;
				}

				max = Math.max(max, cnt);
			}
		}

		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if (box[j][i] == box[j + 1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}

				max = Math.max(max, cnt);
			}
		}

		return max;
	}

}
