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

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String a = br.readLine(), b = a.substring(a.indexOf(' ') + 1);
            a = a.substring(0, a.indexOf(' '));
            sb.append(a).append(" & ").append(b).append(a.length() == b.length() && isAnagram(a, b) ? " are anagrams.\n" : " are NOT anagrams.\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isAnagram(String a, String b) {
        int[] arr = new int[26];
        for (char c : a.toCharArray()) arr[c - 'a']++;
        for (char c : b.toCharArray()) arr[c - 'a']--;
        for (int i : arr) if (i != 0) return false;

        return true;
    }

}
