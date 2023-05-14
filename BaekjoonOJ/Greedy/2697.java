import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0)
            sb.append(find(br.readLine())).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    private static String find(String input) {
        char[] arr = input.toCharArray();
        int idx = input.length() - 1;

        while (idx > 0 && arr[idx - 1] >= arr[idx])
            idx--;

        if (idx == 0)
            return "BIGGEST";

        Arrays.sort(arr, idx, arr.length);

        char c = arr[idx - 1];
        for (int i = idx; i < arr.length; i++) {
            if (c < arr[i]) {
                arr[idx - 1] = arr[i];
                arr[i] = c;
                break;
            }
        }

        return String.valueOf(arr);
    }

}
