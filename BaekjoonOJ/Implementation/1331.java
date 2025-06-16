import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        String s = br.readLine(), a = s, b;
        set.add(a);
        for (int i = 0; i < 35; i++, a = b) if (!isValid(a, b = br.readLine()) || !set.add(b)) break;

        bw.write(set.size() == 36 && isValid(s, a) ? "Valid" : "Invalid");
        bw.flush();
    }

    private static boolean isValid(String a, String b) {
        return Math.abs(a.charAt(0) - b.charAt(0)) * Math.abs(a.charAt(1) - b.charAt(1)) == 2;
    }

}
