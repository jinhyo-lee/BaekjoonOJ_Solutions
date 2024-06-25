import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[26];
        for (int i = 0; i < 26; i++) {
            String s = br.readLine();
            arr[s.charAt(0) - 'A'] = s.substring(2);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringBuilder code = new StringBuilder();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) code.append(arr[s.charAt(i) - 'A']);
            map.put(code.toString(), s);
        }

        int w;
        while ((w = Integer.parseInt(br.readLine())) != 0) {
            String[] codes = new String[w];
            for (int i = 0; i < w; i++) codes[i] = br.readLine();
            sb.append(find(codes)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String find(String[] codes) {
        StringBuilder words = new StringBuilder();
        for (String code : codes) {
            if (map.containsKey(code)) words.append(map.get(code)).append(" ");
            else return code + " not in dictionary.";
        }

        return words.toString();
    }

}
