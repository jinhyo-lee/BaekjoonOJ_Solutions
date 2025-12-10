import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), ":");
        for (int i = 0; i < 3; i++) arr[i] = Integer.parseInt(st.nextToken()) - arr[i];

        if (arr[2] < 0) {
            arr[2] += 60;
            arr[1]--;
        }

        if (arr[1] < 0) {
            arr[1] += 60;
            arr[0]--;
        }

        if (arr[0] < 0) arr[0] += 24;

        bw.write(arr[0] == 0 && arr[1] == 0 && arr[2] == 0 ? "24:00:00" : String.format("%02d:%02d:%02d", arr[0], arr[1], arr[2]));
        bw.flush();
    }

}
