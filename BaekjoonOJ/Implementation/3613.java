import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int i = discriminate(s);
        if (i == 0) bw.write(s);
        else if (i == 1) bw.write(javaToCpp(s));
        else if (i == 2) bw.write(cppToJava(s));
        else bw.write("Error!");

        bw.flush();
    }

    private static int discriminate(String s) {
        if (s.charAt(0) <= '_' || s.charAt(s.length() - 1) == '_') return 3;

        int upper = 0, bar = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) upper = 1;
            else if (s.charAt(i) == '_') {
                bar = 2;
                if (s.charAt(i - 1) == '_') return 3;
            }
        }

        return upper + bar;
    }

    private static String javaToCpp(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append('_').append(Character.toLowerCase(c));
            else sb.append(c);
        }

        return sb.toString();
    }

    private static String cppToJava(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') sb.append(Character.toUpperCase(s.charAt(++i)));
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
