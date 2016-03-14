import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
//        s.init(new BufferedInputStream(System.in));
        s.init(new FileInputStream("9935/input"));
        String string = s.next();
        String bomb = s.next();

        char[] charArray = string.toCharArray();
        int charArrayLength = charArray.length;
        char[] charArrayBomb = bomb.toCharArray();
        int charArrayBombLength = charArrayBomb.length;

        int bombIndex = 0;

        MyStack stack = new MyStack();
        for (int i = 0; i < charArrayLength; ++i) {
            char current = charArray[i];
            stack.pushBack(current);

            if (current == charArrayBomb[0]) {
                bombIndex = 0;
            }

            if (current == charArrayBomb[bombIndex]) {
                bombIndex++;

                if (bombIndex == charArrayBombLength) {
                    stack.popBack(charArrayBombLength);
                    char[] popped = stack.popBack(charArrayBombLength);
                    int poppedLength = popped.length;

                    for (int j = 0; j < poppedLength; ++j) {
                        charArray[i - poppedLength + j + 1] = popped[j];
                    }

                    i -= poppedLength;
                    bombIndex = 0;
                }
            } else {
                bombIndex = 0;
            }
        }

        String result = stack.toString();
        System.out.println("".equals(result) ? "FRULA" : result);
    }

    static class MyStack {
        char[] stack = new char[1000001];
        int current = 0;

        public void pushBack(char character) {
            stack[current++] = character;
        }

        public char popBack() {
            return stack[current--];
        }

        public char[] popBack(int length) {
            if (current < length) {
                length = current;
            }

            char[] result = new char[length];
            for (int i = 0; i < length; ++i) {
                result[i] = stack[current - length + i];
            }

            current -= length;

            return result;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < current; ++i) {
                stringBuilder.append(stack[i]);
            }

            return stringBuilder.toString();
        }
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
    }
}