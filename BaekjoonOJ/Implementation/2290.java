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
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		int len = n.length();

		for (int i = 0; i < len; i++) {
			sb.append(' ');
			for (int j = 0; j < s; j++) {
				if (n.charAt(i) == '1' || n.charAt(i) == '4')
					sb.append(' ');
				else
					sb.append('-');
			}
			sb.append(' ');
			sb.append(' ');
		}
		sb.append('\n');

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < len; j++) {
				if (n.charAt(j) == '1' || n.charAt(j) == '2' || n.charAt(j) == '3' || n.charAt(j) == '7')
					sb.append(' ');
				else
					sb.append('|');

				for (int k = 0; k < s; k++)
					sb.append(' ');

				if (n.charAt(j) == '5' || n.charAt(j) == '6')
					sb.append(' ');
				else
					sb.append('|');

				sb.append(' ');
			}
			sb.append('\n');
		}

		for (int i = 0; i < len; i++) {
			sb.append(' ');
			for (int j = 0; j < s; j++) {
				if (n.charAt(i) == '1' || n.charAt(i) == '7' || n.charAt(i) == '0')
					sb.append(' ');
				else
					sb.append('-');
			}
			sb.append(' ');
			sb.append(' ');
		}
		sb.append('\n');

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < len; j++) {
				if (n.charAt(j) == '2' || n.charAt(j) == '6' || n.charAt(j) == '8' || n.charAt(j) == '0')
					sb.append('|');
				else
					sb.append(' ');

				for (int k = 0; k < s; k++)
					sb.append(' ');

				if (n.charAt(j) == '2')
					sb.append(' ');
				else
					sb.append('|');

				sb.append(' ');
			}
			sb.append('\n');
		}

		for (int i = 0; i < len; i++) {
			sb.append(' ');
			for (int j = 0; j < s; j++) {
				if (n.charAt(i) == '1' || n.charAt(i) == '4' || n.charAt(i) == '7')
					sb.append(' ');
				else
					sb.append('-');
			}
			sb.append(' ');
			sb.append(' ');
		}
		sb.append('\n');
		
		bw.write(sb + "");
		bw.flush();
	}

}
