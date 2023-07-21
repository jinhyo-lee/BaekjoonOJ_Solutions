import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int k;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            k = Integer.parseInt(br.readLine());
            arr = new String[k];

            for (int i = 0; i < k; i++)
                arr[i] = br.readLine();

            sb.append(getPalindrome()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static String getPalindrome() {
        for (int i = 0; i < k; i++) {
            String word = arr[i];
            for (int j = 0; j < k; j++) {
                if (i == j) continue;

                String concat = word.concat(arr[j]);
                if (isPalindrome(concat)) return concat;
            }
        }

        return "0";
    }

    private static boolean isPalindrome(String concat) {
        int half = concat.length() / 2;

        for (int i = 0; i < half; i++)
            if (concat.charAt(i) != concat.charAt(concat.length() - i - 1)) return false;

        return true;
    }

}
