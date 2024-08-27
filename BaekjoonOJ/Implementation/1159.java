import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new TreeSet<>();
        int[] arr = new int[123];

        char i;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) if (++arr[i = br.readLine().charAt(0)] > 4) set.add(i);

        if (set.isEmpty()) sb.append("PREDAJA");
        else for (char c : set) sb.append(c);

        bw.write(sb.toString());
        bw.flush();
    }

}
