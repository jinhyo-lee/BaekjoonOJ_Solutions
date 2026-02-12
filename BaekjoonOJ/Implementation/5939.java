import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Time[] arr = new Time[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = new Time(read(), read(), read());
        Arrays.sort(arr);

        for (Time t : arr) sb.append(t.h).append(' ').append(t.m).append(' ').append(t.s).append('\n');

        bw.write(sb.toString());
        bw.close();
    }

    private static class Time implements Comparable<Time> {
        int h, m, s, sum;

        Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
            this.sum = h * 10000 + m * 100 + s;
        }

        @Override
        public int compareTo(Time o) {
            return this.sum - o.sum;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
