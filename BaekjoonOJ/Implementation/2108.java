import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int n = read(), sum = 0, max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            sum += arr[i] = read();
            int v = map.getOrDefault(arr[i], 0) + 1;
            if (max <= v) {
                if (max < v) list.clear();
                list.add(arr[i]);
                max = v;
            }
            map.put(arr[i], v);
        }

        Arrays.sort(arr);
        Collections.sort(list);

        bw.write(sb.append(Math.round((double) sum / n)).append('\n').append(arr[n / 2]).append('\n').append(list.get(list.size() > 1 ? 1 : 0)).append('\n').append(arr[n - 1] - arr[0]).toString());
        bw.flush();
    }


    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean flag = n == 13;

        if (flag) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return flag ? ~n + 1 : n;
    }

}
