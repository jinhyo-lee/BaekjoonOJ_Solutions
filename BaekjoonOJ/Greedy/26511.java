import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            for (char c : br.readLine().toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

            Pair[] arr = new Pair[map.size()];
            int i = 0;
            for (char c : map.keySet()) arr[i++] = new Pair(c, map.get(c));
            Arrays.sort(arr);

            int sum = 0, j = map.size() - 2;
            for (i = 0; i < j; i++) sum += arr[i].i;

            sb.append(sum).append('\n');
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        char c;
        int i;

        Pair(char c, int i) {
            this.c = c;
            this.i = i;
        }

        @Override
        public int compareTo(Pair o) {
            return this.i != o.i ? this.i - o.i : this.c - o.c;
        }
    }

}
