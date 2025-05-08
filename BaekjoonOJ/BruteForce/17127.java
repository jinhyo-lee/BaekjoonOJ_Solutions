import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[read()];
        for (int i = 0; i < arr.length; i++) arr[i] = read();

        int max = 0;
        for (int i = 0; i < arr.length - 3; i++)
            for (int j = i + 1; j < arr.length - 2; j++)
                for (int k = j + 1; k < arr.length - 1; k++)
                    max = Math.max(max, mul(0, i) + mul(i + 1, j) + mul(j + 1, k) + mul(k + 1, arr.length - 1));

        bw.write(String.valueOf(max));
        bw.flush();
    }

    private static int mul(int i, int j) {
        int mul = 1;
        while (i <= j) mul *= arr[i++];

        return mul;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}
