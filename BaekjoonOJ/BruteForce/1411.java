import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) arr[i] = convert(br.readLine());

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) for (int j = i + 1; j < arr.length; j++) if (arr[i] == arr[j]) cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static int convert(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 1, sum = 0;
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, i++);
            sum = sum * 10 + map.get(c);
        }

        return sum;
    }

}
