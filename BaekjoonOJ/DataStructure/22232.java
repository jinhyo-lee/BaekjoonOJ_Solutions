import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String ln = br.readLine();
        int n = Integer.parseInt(ln.substring(0, ln.indexOf(' '))), m = Integer.parseInt(ln.substring(ln.indexOf(' ') + 1));

        String[] arr = new String[n];
        while (n-- > 0) arr[n] = br.readLine();
        while (m-- > 0) set.add(br.readLine());

        PriorityQueue<File> pq = new PriorityQueue<>();
        for (String s : arr) pq.offer(new File(s));
        while (!pq.isEmpty()) {
            File f = pq.poll();
            sb.append(f.name).append('.').append(f.ext).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static class File implements Comparable<File> {
        String name, ext;
        boolean flag;

        File(String s) {
            int i = s.indexOf('.');
            this.name = s.substring(0, i);
            this.ext = s.substring(i + 1);
            this.flag = set.contains(this.ext);
        }

        @Override
        public int compareTo(File o) {
            return name.equals(o.name) ? flag && !o.flag ? -1 : !flag && o.flag ? 1 : ext.compareTo(o.ext) : name.compareTo(o.name);
        }
    }

}
