import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[5];
        for (int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int min = arr[0];
        while (!isMultiple(min))
            min++;

        bw.write(String.valueOf(min));
        bw.flush();
    }

    private static boolean isMultiple(int min) {
        int cnt = 0;
        for (int i = 0; i < 5 && cnt < 3; i++) {
            if (min % arr[i] == 0)
                cnt++;
        }

        return cnt == 3;
    }

}
