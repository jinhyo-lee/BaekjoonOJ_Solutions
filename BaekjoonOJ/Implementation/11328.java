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
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();
            if (a.length() != b.length()) {
                sb.append("Impossible\n");
                continue;
            }

            int[] arr = new int[26];
            for (int i = 0; i < a.length(); i++) arr[a.charAt(i) - 'a']++;
            for (int i = 0; i < b.length(); i++) arr[b.charAt(i) - 'a']--;
            sb.append(isPossible(arr) ? "Possible\n" : "Impossible\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isPossible(int[] arr) {
        for (int i : arr) if (i > 0) return false;
        return true;
    }

}
