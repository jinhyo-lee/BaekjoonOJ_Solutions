import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split("-");

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			String[] part = input[i].split("\\+");

			int sum = 0;
			for (int j = 0; j < part.length; j++)
				sum += Integer.parseInt(part[j]);

			if (result == Integer.MAX_VALUE)
				result = sum;
			else
				result -= sum;
		}

		bw.write(result + "\n");
		bw.flush();
	}

}
