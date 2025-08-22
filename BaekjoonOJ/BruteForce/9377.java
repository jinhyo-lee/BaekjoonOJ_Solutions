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

        String s;
        while ((s = br.readLine()).charAt(0) != '0') {
            String[] arr = new String[Integer.parseInt(s)];
            for (int i = 0; i < arr.length; i++) arr[i] = br.readLine();
            sb.append(count(arr)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int count(String[] arr) {
        int cnt = 0;
        while (true) {
            for (int i = 0; i < arr.length; i++) if ((arr[i] = arr[i].substring(1)).isEmpty()) return cnt;
            for (int i = arr.length - 1; i > 0; i--)
                for (int j = i - 1; j >= 0; j--) if (arr[i].equals(arr[j])) return cnt;
            cnt++;
        }
    }

}
