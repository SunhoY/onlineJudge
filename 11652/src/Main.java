import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        s.init(new BufferedInputStream(System.in));

        int size = s.nextInt();
        List<Long> input = new ArrayList<>();


        for(int i = 0; i < size; ++i) {
            input.add(s.nextLong());
        }

        Comparator<Long> comparator = new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1 > o2 ? -1 : o1 == 02 ? 0 : 1;
            }
        };

        Collections.sort(input, comparator);

        System.out.println(Math.pow(2, 62));

        long targetValue = input.get(0);
        int targetCount = 1;
        long maxValue = Long.MIN_VALUE;
        int maxCount = 0;

        for(int i = 1; i < size; ++i) {
            long currentValue = input.get(i);

            if(targetValue == currentValue) {
                targetCount++;
            }
            else {
                if(targetCount >= maxCount) {
                    maxCount = targetCount;
                    maxValue = targetValue;
                }

                targetValue = currentValue;
                targetCount = 1;
            }
        }
        if(targetCount >= maxCount) {
            maxCount = targetCount;
            maxValue = targetValue;
        }

        System.out.println(maxValue);
    }

    static class s {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static long nextLong()  throws IOException {
            return Long.parseLong(next());
        }
    }
}
