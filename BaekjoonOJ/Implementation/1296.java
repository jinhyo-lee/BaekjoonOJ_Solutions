import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        for (char c : br.readLine().toCharArray()) arr[c - 'A']++;

        String res = "[";
        int n = Integer.parseInt(br.readLine()), max = -1;
        while (n-- > 0) {
            int[] tmp = arr.clone();
            String s = br.readLine();
            for (char c : s.toCharArray()) tmp[c - 'A']++;

            int i = calc(tmp);
            if (max < i) {
                max = i;
                res = s;
            } else if (max == i) res = res.compareTo(s) < 0 ? res : s;
        }

        bw.write(res);
        bw.flush();
    }

    private static int calc(int[] tmp) {
        int[] arr = {tmp[11], tmp[14], tmp[21], tmp[4]};
        int sum = 1;
        for (int i = 0; i < 3; i++) for (int j = i + 1; j < 4; j++) sum *= arr[i] + arr[j];

        return sum % 100;
    }

}
