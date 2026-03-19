import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] arr = {false, false, false, false, false, false, false, true, true, false, false, false, false, true, false, true, false, false, true, false, false, false, false, true, false, true};
        boolean flag = false;
        for (char c : br.readLine().toCharArray()) flag = arr[c - 'A'];

        bw.write(flag ? "YES" : "NO");
        bw.flush();
    }

}
