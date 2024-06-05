import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        arr = new boolean[read() + 1];
        for (int i = 1; i < arr.length; i++) arr[i] = read() == 1;

        for (int i = read(); i >= 1; i--) {
            if (read() == 1) multiple(read());
            else symmetry(read());
        }

        for (int i = 1; i < arr.length; i++) sb.append(arr[i] ? 1 : 0).append(i % 20 == 0 ? " \n" : " ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static void multiple(int n) {
        for (int i = n; i < arr.length; i += n) arr[i] = !arr[i];
    }

    private static void symmetry(int n) {
        arr[n] = !arr[n];

        int l = n, r = n;
        while (--l > 0 && ++r < arr.length && arr[l] == arr[r]) {
            arr[l] = !arr[l];
            arr[r] = !arr[r];
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
