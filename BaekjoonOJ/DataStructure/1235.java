import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();

        Set<String> set = new HashSet<>();
        int len = arr[0].length(), k = 1;

        for (int i = 0; i < n; i++) {
            String sub = arr[i].substring(len - k);
            if (!set.contains(sub))
                set.add(sub);
            else {
                k++;
                i = -1;
                set.clear();
            }
        }

        bw.write(String.valueOf(k));
        bw.flush();
    }

}
