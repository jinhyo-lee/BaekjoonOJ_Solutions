import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		StringBuilder t = new StringBuilder(br.readLine());

		while (s.length() < t.length()) {
			if (t.charAt(t.length() - 1) == 'A')
				t.deleteCharAt(t.length() - 1);
			else
				t.deleteCharAt(t.length() - 1).reverse();
		}

		int result = 0;
		if (s.equals(t.toString()))
			result = 1;

		bw.write(result + "\n");
		bw.flush();
	}

}
