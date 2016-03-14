import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("1673/src/input"));
//        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int total = n;

            while(n >= k) {
                total += n / k;

                n = (n / k) + (n % k);
            }

            System.out.println(total);
        }
    }
}