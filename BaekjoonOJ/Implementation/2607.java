import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String src = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < src.length(); i++) arr[src.charAt(i) - 'A']++;

        int res = 0;
        while (n-- > 1) {
            String tgt = br.readLine();
            int[] tmp = arr.clone();
            int cnt = 0;
            for (int i = 0; i < tgt.length(); i++) {
                if (tmp[tgt.charAt(i) - 'A'] == 0) continue;
                tmp[tgt.charAt(i) - 'A']--;
                cnt++;
            }

            if (compare(src.length(), tgt.length(), cnt)) res++;
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }

    private static boolean compare(int src, int tgt, int cnt) {
        return (Math.abs(src - tgt) == 1 && Math.min(src, tgt) == cnt) || (src == tgt && (tgt == cnt || tgt - cnt == 1));
    }

}
