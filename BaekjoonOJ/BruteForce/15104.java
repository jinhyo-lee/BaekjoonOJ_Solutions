import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) for (int j = i + 2; j <= s.length(); j += 2) list.add(s.substring(i, j));

        bw.write(isOdd(list) ? "Odd." : "Or not.");
        bw.flush();
    }

    private static boolean isOdd(List<String> list) {
        for (String s : list) if (isPalindrome(s)) return false;

        return true;
    }

    private static boolean isPalindrome(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return true;
    }

}
