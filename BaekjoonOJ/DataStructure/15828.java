import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> router = new LinkedList<>();
        while (true) {
            int packet = Integer.parseInt(br.readLine());

            if (packet == -1)
                break;

            if (packet == 0)
                router.poll();
            else if (router.size() < n)
                router.offer(packet);
        }

        if (router.isEmpty())
            bw.write("empty");
        else {
            while (!router.isEmpty())
                bw.write(router.poll() + "\n");
        }

        bw.flush();
    }

}
