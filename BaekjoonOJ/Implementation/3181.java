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
        StringBuilder sb = new StringBuilder();

        Set<String> set = init();
        String[] arr = br.readLine().split(" ");

        sb.append(arr[0].charAt(0));
        for (int i = 1; i < arr.length; i++) if (!set.contains(arr[i])) sb.append(arr[i].charAt(0));

        bw.write(sb.toString().toUpperCase());
        bw.flush();
    }

    private static Set<String> init() {
        Set<String> set = new HashSet<>();
        set.add("i");
        set.add("pa");
        set.add("te");
        set.add("ni");
        set.add("niti");
        set.add("a");
        set.add("ali");
        set.add("nego");
        set.add("no");
        set.add("ili");

        return set;
    }

}
