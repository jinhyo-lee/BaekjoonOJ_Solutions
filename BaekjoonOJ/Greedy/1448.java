import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        while (n-- > 0)
            arr[n] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        bw.write(String.valueOf(find()));
        bw.flush();
    }

    private static int find() {
        for (int i = arr.length - 3; i >= 0; i--) {
            if (arr[i] + arr[i + 1] > arr[i + 2])
                return arr[i] + arr[i + 1] + arr[i + 2];
        }

        return -1;
    }

}
