import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] number;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		number = new int[n];
		operator = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			number[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) 
			operator[i] = Integer.parseInt(st.nextToken());
		
		recursion(number[0], 1);
		
		bw.write(max + "\n" + min + "\n");
		bw.flush();
	}

	private static void recursion(int num, int idx) {
		if (idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				if (i == 0)
					recursion(num + number[idx], idx + 1);
				else if (i == 1)
					recursion(num - number[idx], idx + 1);
				else if (i == 2)
					recursion(num * number[idx], idx + 1);
				else
					recursion(num / number[idx], idx + 1);

				operator[i]++;
			}
		}
	}

}
