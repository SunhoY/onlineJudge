import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("8958/input"));
//        Scanner sc = new Scanner(System.in);

        int pNum = sc.nextInt();

        for (int i = 0; i < pNum; ++i) {
            String problem = sc.next();
            int score = 0;
            int tScore = 0;

            for (int str_i = 0; str_i < problem.length(); ++str_i) {
                char word = problem.charAt(str_i);

                if (word == 'O') {
                    tScore += ++score;
                } else {
                    tScore += score = 0;
                }
            }

            System.out.println(tScore);
        }
    }
}