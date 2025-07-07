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
        for (int i = 0; i < arr.length; i++) {
            if (isUpperCase(arr[i])) arr[i] = (char) ('A' + (arr[i] - 'A' + 13) % 26);
            else if (isLowerCase(arr[i])) arr[i] = (char) ('a' + (arr[i] - 'a' + 13) % 26);
        }

        bw.write(new String(arr));
        bw.flush();
    }

    private static boolean isUpperCase(char c) {
        return '@' < c && c < '[';
    }

    private static boolean isLowerCase(char c) {
        return '`' < c && c < '{';
    }

}
