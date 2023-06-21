import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static Pair[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());

        arr = new Pair[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Pair(Long.parseLong(a.nextToken()), Long.parseLong(b.nextToken()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(binarySearch(i)).append(" ");

        bw.write(sb.toString());
        bw.flush();
    }

    private static int binarySearch(int i) {
        int left = i, right = arr.length - 1;
        long tgt = arr[i].a;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid].b > tgt) right = mid - 1;
            else left = mid + 1;
        }

        return right - i;
    }

    private static class Pair {
        long a, b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

}
