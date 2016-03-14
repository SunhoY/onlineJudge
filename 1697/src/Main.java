import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static int[] WALK = {-1, 1};
    private static int sol = Integer.MAX_VALUE;

    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("1697/src/input"));
//        Scanner sc = new Scanner(System.in);

        int posSW = sc.nextInt();
        int posDJ = sc.nextInt();

        calcSeconds(posSW, posDJ, 0);

        System.out.println(sol);

        sc.close();
    }

    private static void calcSeconds(int posSW, int posDJ, int cost) {
        if(posSW == posDJ) {
            if(cost < sol) {
                sol = cost;
            }

            return;
        }

        boolean isEven = posDJ % 2 == 0;

        if(isEven) {
            int posAfterTP = posDJ / 2;

            int gapBeforeTP = Math.abs(posDJ - posSW);
            int gapAfterTP = Math.abs(posAfterTP - posSW);

            if(gapBeforeTP <= gapAfterTP + 1) {
                int newSol = cost + gapBeforeTP;

                if(newSol < sol) {
                    sol = newSol;
                }

                return;
            }
            else {
                calcSeconds(posSW, posAfterTP, cost + 1);
            }
        }
        else {
            for(int i = 0; i < WALK.length; ++i) {
                calcSeconds(posSW, posDJ + WALK[i], cost + 1);
            }
        }

        return;
    }
}