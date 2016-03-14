import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static TreeSet<Integer> cache = new TreeSet<Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("1978/src/input"));
//        Scanner sc = new Scanner(System.in);
        int pNum = sc.nextInt();
        int primalCnt = 0;

        for (int i = 0; i < pNum; i++) {
            int input = sc.nextInt();

            primalCnt = isPrimal(input) ? primalCnt + 1 : primalCnt;
        }
        System.out.println(primalCnt);
    }

    public static boolean isPrimal(int number) {
        if(cache.contains(number)) {
            return true;
        }

        boolean isPrimal = true;

        if(number == 1) {
            return false;
        }

        for(int j = 2; j < number; ++j) {
            if(number % j == 0) {
                isPrimal = false;
                break;
            }
        }

        cache.add(number);
        return isPrimal;
    }
}