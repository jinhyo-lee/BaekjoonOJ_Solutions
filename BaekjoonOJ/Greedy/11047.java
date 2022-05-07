import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] vals = new int[n];

		for (int i = 0; i < n; i++) {
			vals[i] = sc.nextInt();
		}

		sc.close();

		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			int s = vals[i];
			cnt += k / s;
			k = k % s;
		}

		System.out.println(cnt);
	}

}
