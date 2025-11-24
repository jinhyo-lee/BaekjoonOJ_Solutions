import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Data[] arr = new Data[read()];
        int max = 0;
        for (int i = 0; i < arr.length; i++) max = Math.max(max, (arr[i] = new Data(read(), read(), read())).x);
        Arrays.sort(arr);

        int[] cnt = new int[max + 1];
        int lmt = 3;
        for (Data d : arr) {
            if (cnt[d.x]++ > 1) continue;
            sb.append(d.x).append(' ').append(d.y).append('\n');
            if (--lmt == 0) break;
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Data implements Comparable<Data> {
        int x, y, z;

        Data(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Data o) {
            return o.z - this.z;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
