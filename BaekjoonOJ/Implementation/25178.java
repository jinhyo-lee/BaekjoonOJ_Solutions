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
        String a = br.readLine(), b = br.readLine();

        bw.write(conditionA(a, b, n) && conditionB(a, b, n) && conditionC(a, b, n) ? "YES" : "NO");
        bw.flush();
    }

    private static boolean conditionA(String a, String b, int n) {
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[a.charAt(i) - 'a']++;
            arr[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) if (arr[i] != 0) return false;

        return true;
    }

    private static boolean conditionB(String a, String b, int n) {
        return a.charAt(0) == b.charAt(0) && a.charAt(n - 1) == b.charAt(n - 1);
    }

    private static boolean conditionC(String a, String b, int n) {
        int i = -1, j = -1;
        do {
            do i++; while (i < n && isVowel(a.charAt(i)));
            do j++; while (j < n && isVowel(b.charAt(j)));
        } while (i < n && j < n && a.charAt(i) == b.charAt(j));

        return i == n && j == n;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
