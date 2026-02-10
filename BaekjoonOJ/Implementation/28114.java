import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Data[] arr = {new Data(br.readLine()), new Data(br.readLine()), new Data(br.readLine())};

        Arrays.sort(arr, Comparator.comparingInt(o -> o.y % 100));
        for (Data d : arr) sb.append(d.y % 100);
        sb.append('\n');

        Arrays.sort(arr, (o1, o2) -> o2.p - o1.p);
        for (Data d : arr) sb.append(d.s.charAt(0));
        sb.append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Data {
        int p, y;
        String s;

        Data(String s) {
            int i = s.indexOf(' '), j = s.indexOf(' ', i + 1);
            this.p = Integer.parseInt(s.substring(0, i));
            this.y = Integer.parseInt(s.substring(i + 1, j));
            this.s = s.substring(j + 1);
        }
    }

}
