import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        Stack<Character> stk = new Stack<>();

        for (int i = 0; arr[i] != '*'; i++) {
            if (arr[i] == '(') stk.push(arr[i]);
            else stk.pop();
        }

        bw.write(String.valueOf(stk.size()));
        bw.flush();
    }

}
