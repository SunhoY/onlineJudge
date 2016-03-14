import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        s.init(new FileInputStream("8320/input"));
//        s.init(new BufferedInputStream(System.in));
        int n = s.nextInt();
        long count = 0L;

        for(int i = 1; i <= n; ++i) {
            int next = n / i;
//            int next = n;
            for(int j = i; j <= next; ++j) {
                if(i * j <= n) {
                    count += 1L;
                }
            }
        }

        System.out.println(count);
    }

    static class s {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                tokenizer = new StringTokenizer(
                        reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt( next() );
        }
    }
}