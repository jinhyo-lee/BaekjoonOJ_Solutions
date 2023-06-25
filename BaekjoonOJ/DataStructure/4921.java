import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Character, char[][]> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        init();

        String input;
        int seq = 1;
        while (!(input = br.readLine()).equals("0")) {
            if (isValid(input)) sb.append(seq++).append(". VALID\n");
            else sb.append(seq++).append(". NOT\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isValid(String s) {
        int len = s.length() - 1;

        if (s.charAt(0) != '1' || s.charAt(len) != '2') return false;

        for (int i = 1; i < len; i++)
            if (!validate(s.charAt(i), s.charAt(i - 1), s.charAt(i + 1))) return false;

        return true;
    }

    private static boolean validate(char key, char prev, char next) {
        char[][] pairs = map.get(key);
        if (pairs == null) return false;

        for (char[] pair : pairs)
            if (pair[0] == prev && pair[1] == next) return true;

        return false;
    }

    private static void init() {
        map = new HashMap<>();

        map.put('3', new char[][]{{'4', '4'}, {'4', '5'}, {'6', '4'}, {'6', '5'}});
        map.put('4', new char[][]{{'1', '2'}, {'1', '3'}, {'3', '2'}, {'3', '3'}});
        map.put('5', new char[][]{{'1', '8'}, {'3', '8'}});
        map.put('6', new char[][]{{'8', '2'}, {'8', '3'}});
        map.put('7', new char[][]{{'8', '8'}});
        map.put('8', new char[][]{{'5', '6'}, {'5', '7'}, {'7', '6'}, {'7', '7'}});
    }

}
