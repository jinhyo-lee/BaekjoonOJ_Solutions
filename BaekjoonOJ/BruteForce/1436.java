import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int num = 666;

		int cnt = 1;
		while (cnt != n) {
			num++;
			if (check(num))
				cnt++;
		}

		bw.write(num + "\n");
		bw.flush();
	}

	private static boolean check(int num) {
		int cnt = 0;

		while (cnt != 3) {
			int i = num % 10;

			if (i == 6)
				cnt++;
			else
				cnt = 0;

			num = num / 10;
			if (num == 0)
				break;
		}

		if (cnt == 3)
			return true;
		else
			return false;
	}

}
