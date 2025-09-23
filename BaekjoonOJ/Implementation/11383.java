import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = new String[Integer.parseInt(br.readLine().split(" ")[0])];
        for (int i = 0; i < arr.length; i++) arr[i] = br.readLine();

        boolean b = false;
        for (String s : arr) if (!(b = compare(s, br.readLine()))) break;

        bw.write(b ? "Eyfa" : "Not Eyfa");
        bw.flush();
    }

    private static boolean compare(String a, String b) {
        for (int i = 0, j = 0; i < a.length(); i++, j += 2)
            if (a.charAt(i) != b.charAt(j) || a.charAt(i) != b.charAt(j + 1)) return false;

        return true;
    }

}
