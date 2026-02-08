import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String[] arr = br.readLine().split(" ");
            sb.append("Case ").append(i).append(calc(Integer.parseInt(arr[0]), arr[1].charAt(0), Integer.parseInt(arr[2]), Integer.parseInt(arr[4])) ? ": YES\n" : ": NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean calc(int x, char o, int y, int z) {
        return o == '+' ? x + y == z : x - y == z;
    }

}
