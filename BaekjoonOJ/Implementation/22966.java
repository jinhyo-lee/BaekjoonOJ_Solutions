import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pair[] arr = new Pair[Integer.parseInt(br.readLine())];
        for (int i = 0; i < arr.length; i++) arr[i] = new Pair(br.readLine());
        Arrays.sort(arr);

        bw.write(arr[0].s);
        bw.flush();
    }

    private static class Pair implements Comparable<Pair> {
        String s;
        int i;

        Pair(String s) {
            int idx = s.indexOf(' ');
            this.s = s.substring(0, idx);
            this.i = Integer.parseInt(s.substring(idx + 1));
        }

        @Override
        public int compareTo(Pair o) {
            return this.i - o.i;
        }
    }

}
