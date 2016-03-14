import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static final int M = 8;
    private static final String chessman = "F";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("1100/input"));
//        Scanner sc = new Scanner(System.in);
        int count = 0;

        for (int i = 0; i < M; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                String val = String.valueOf(line.charAt(j));

                boolean isEvenNumber = (i + j) % 2 == 0 ? true : false;

                if(isEvenNumber && chessman.equals(val)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
