import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];
        int src = 1000;
        int dest = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[l] = h;
            src = Math.min(src, l);
            dest = Math.max(dest, l);
        }

        Stack<Integer> stk = new Stack<>();

        int pivot = arr[src];
        for (int i = src + 1; i <= dest; i++) {
            if (arr[i] < pivot)
                stk.push(i);
            else {
                while (!stk.empty())
                    arr[stk.pop()] = pivot;
                pivot = arr[i];
            }
        }

        stk.clear();

        pivot = arr[dest];
        for (int i = dest - 1; i >= src; i--) {
            if (arr[i] < pivot)
                stk.push(i);
            else {
                while (!stk.empty())
                    arr[stk.pop()] = pivot;
                pivot = arr[i];
            }
        }

        int res = 0;
        for (int i = src; i <= dest; i++)
            res += arr[i];

        bw.write(String.valueOf(res));
        bw.flush();
    }

}
