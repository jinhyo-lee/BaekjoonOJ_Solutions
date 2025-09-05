import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[read()];
        for (int i = 0; i < arr.length; ) arr[i] = ++i;

        int k = read();
        while (k-- > 0) paste(arr, read(), read(), read());

        for (int i = 0; i < 10; i++) sb.append(arr[i]).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }

    public static void paste(int[] arr, int from, int to, int tgt) {
        int len = to - --from;
        if (len == 0) return;

        if (tgt < from) {
            reverse(arr, tgt, from);
            reverse(arr, from, to);
            reverse(arr, tgt, to);
        } else {
            reverse(arr, from, to);
            reverse(arr, to, tgt + len);
            reverse(arr, from, tgt + len);
        }
    }

    private static void reverse(int[] arr, int from, int to) {
        while (from < --to) {
            int i = arr[from];
            arr[from++] = arr[to];
            arr[to] = i;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
