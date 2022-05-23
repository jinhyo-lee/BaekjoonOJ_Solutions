import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();
		int[] arr = new int[10];
		
		int len = n.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			int num = n.charAt(i) - '0';
			arr[num] += 1;
			sum += num;
		}

		if (n.contains("0") && sum % 3 == 0) {
			for (int i = 9; i >= 0; i--) {
				while (arr[i] > 0) {
					bw.write(i + "");
					arr[i]--;
				}
			}
		} else {
			bw.write(-1 + "\n");
		}

		bw.flush();
	}

}
