import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

    private static final int MAX = 2001;
    private static int[][] cache = new int[MAX][MAX];
    private static int DEVIDE_NUM = 100999;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("9764/input"));
//        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                cache[i][j] = -1;
            }
        }

        int pCount = sc.nextInt();
        for (int i = 0; i < pCount; ++i) {
            int problem = sc.nextInt();
            int localSol = dp(problem, problem);
            System.out.println(localSol);
        }
    }

    private static int dp(int targetSum, int start) {
        if(cache[targetSum][start] != -1) {
            return cache[targetSum][start];
        }

        int localSol = 0;
        if(start == 0) {
            return cache[targetSum][start] = localSol % DEVIDE_NUM;
        }
        int newStart = start;
        if(targetSum == start) {
            localSol++;
            newStart--;
        }


        for(int i = newStart; i > 0; --i) {
            int nextRest = targetSum - i;

            localSol += dp(nextRest, Math.min(nextRest, i - 1));
        }

        return cache[targetSum][start] = localSol % DEVIDE_NUM;
    }
}