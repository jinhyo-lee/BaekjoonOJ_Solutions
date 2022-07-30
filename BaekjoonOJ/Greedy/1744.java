import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		List<Integer> pn = new ArrayList<>();
		List<Integer> nn = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 0)
				pn.add(num);
			else
				nn.add(num);
		}

		Collections.sort(pn, Collections.reverseOrder());
		Collections.sort(nn);

		int sum = 0;
		for (int i = 0; i < pn.size(); i++) {
			if (i + 1 < pn.size() && pn.get(i) != 1 && pn.get(i + 1) != 1)
				sum += pn.get(i++) * pn.get(i);
			else
				sum += pn.get(i);
		}

		for (int i = 0; i < nn.size(); i++) {
			if (i + 1 < nn.size())
				sum += nn.get(i++) * nn.get(i);
			else
				sum += nn.get(i);
		}

		bw.write(sum + "\n");
		bw.flush();
	}

}
