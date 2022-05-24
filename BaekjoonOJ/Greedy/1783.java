import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		int result = 0;
		if (n == 1)
			result = 1;
		else if (n == 2)
			result = Math.min((m + 1) / 2, 4);
		else if (m < 7)
			result = Math.min(m, 4);
		else
			result = m - 2;

		bw.write(result + "\n");
		bw.flush();
	}

}
