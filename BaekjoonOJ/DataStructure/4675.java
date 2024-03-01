import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Set<String>> map = new HashMap<>();
        String s;
        while ((s = br.readLine()).charAt(0) != 'X') {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            Set<String> set = map.getOrDefault(key, new TreeSet<>());
            set.add(s);
            map.put(key, set);
        }

        while ((s = br.readLine()).charAt(0) != 'X') {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (map.containsKey(key)) for (String value : map.get(key)) sb.append(value).append("\n");
            else sb.append("NOT A VALID WORD\n");

            sb.append("******\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
