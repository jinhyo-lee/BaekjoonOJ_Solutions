import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n, m;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new Node[(n = read()) + (m = read()) - 1];
        int i = 0;
        for (int j = 1; j <= n; j++) arr[i++] = new Node(j, 1, read());
        for (int j = 2; j <= m; j++) arr[i++] = new Node(n, j, read());

        bw.write(search());
        bw.flush();
    }

    private static String search() {
        for (int i = 1; i <= n; i++) for (int j = 1; j <= m; j++) if (measure(i, j)) return i + " " + j;

        return "";
    }

    private static boolean measure(int y, int x) {
        for (Node n : arr) if (Math.abs(n.y - y) + Math.abs(n.x - x) != n.w) return false;

        return true;
    }

    private static class Node {
        int y, x, w;

        Node(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
