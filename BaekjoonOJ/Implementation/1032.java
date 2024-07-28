import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        while (n-- > 0) arr[n] = br.readLine();

        for (int i = 0; i < arr[0].length(); i++) sb.append(compare(i));

        bw.write(sb.toString());
        bw.flush();
    }

    private static char compare(int i) {
        char c = arr[0].charAt(i);
        for (int j = 1; j < arr.length; j++) if (arr[j].charAt(i) != c) return '?';

        return c;
    }

}
