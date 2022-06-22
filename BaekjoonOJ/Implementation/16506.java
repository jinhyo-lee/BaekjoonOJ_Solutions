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

		int n = Integer.parseInt(br.readLine());
		String[] codes = { "ADD", "SUB", "MOV", "AND", "OR", "NOT", "MULT", "LSFTL", "LSFTR", "ASFTR", "RL", "RR" };

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String code = st.nextToken();
			int rD = Integer.parseInt(st.nextToken());
			int rA = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());

			for (int j = 0; j < codes.length; j++) {
				if (code.equals(codes[j])) {
					bw.write(binary(j, 4) + "00" + binary(rD, 3) + binary(rA, 3) + binary(bc, 3) + '0' + "\n");
					break;
				}
				if (code.equals(codes[j] + 'C')) {
					bw.write(binary(j, 4) + "10" + binary(rD, 3) + binary(rA, 3) + binary(bc, 4) + "\n");
					break;
				}
			}
		}

		bw.flush();
	}

	private static String binary(int n, int digit) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < digit; i++) {
			sb.append(n % 2);
			n = n / 2;
		}

		return sb.reverse().toString();
	}

}
