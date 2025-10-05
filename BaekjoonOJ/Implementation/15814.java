import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int i = s.indexOf(' ');
            swap(arr, Integer.parseInt(s.substring(0, i)), Integer.parseInt(s.substring(i + 1)));
        }

        bw.write(arr);
        bw.flush();
    }

    private static void swap(char[] arr, int a, int b) {
        char c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

}
