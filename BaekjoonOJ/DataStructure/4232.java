import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Array, Integer> map = new HashMap<>();
        int n;
        while ((n = read()) != 0) {
            Array[] mat = new Array[n];
            while (n-- > 0) {
                int[] arr = new int[5];
                for (int i = 0; i < 5; i++) arr[i] = read();
                Arrays.sort(arr);

                map.put(mat[n] = new Array(arr), map.getOrDefault(mat[n], 0) + 1);
            }

            int max = 0, cnt = 0;
            for (Array arr : mat) {
                int i = map.get(arr);
                if (max < i) {
                    max = i;
                    cnt = 1;
                } else if (max == i) cnt++;
            }

            sb.append(cnt).append('\n');
            map.clear();
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class Array {
        private final int[] arr;

        public Array(int[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Array)) return false;
            return Arrays.equals(arr, ((Array) obj).arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
