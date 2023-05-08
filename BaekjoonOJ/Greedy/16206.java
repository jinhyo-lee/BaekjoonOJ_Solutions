import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 10 != o2 % 10)
                    return o1 % 10 - o2 % 10;

                return o1 - o2;
            }
        });

        int cnt = 0;
        for (int input : arr) {
            if (input < 10)
                continue;

            int div = input / 10;
            int cut = input % 10 == 0 ? div - 1 : div;

            if (cut == 0) {
                cnt++;
            } else {
                if (cut > m) {
                    cnt += m;
                    break;
                } else {
                    cnt += div;
                    m -= cut;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}
