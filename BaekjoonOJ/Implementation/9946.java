import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 0;
        String s;
        while (!(s = br.readLine()).equals("END"))
            sb.append("Case ").append(++t).append(isSame(s.toLowerCase(), br.readLine().toLowerCase()) ? ": same\n" : ": different\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isSame(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] arr = new int[26];
        for (int i = a.length() - 1; i >= 0; i--) {
            arr[a.charAt(i) - 'a']++;
            arr[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) if (arr[i] != 0) return false;

        return true;
    }

}
