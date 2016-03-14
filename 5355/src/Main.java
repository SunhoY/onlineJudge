import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("5355/input"));
//        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(System.getProperty("line.separator"));
        int pNum = sc.nextInt();

        for (int i = 0; i < pNum; i++) {
            String str = sc.next();
            String[] problem = str.split(" ");

            double sol = solve(problem);

            int intSol = (int)(sol * 100);
            String strSol = String.valueOf(intSol);
            int strSolLength = strSol.length();

            System.out.println(strSol.substring(0, strSolLength - 2) + "." + strSol.substring(strSolLength - 2));
        }
    }

    private static double solve(String[] problem) {
        int length = problem.length;
        double sol = Double.valueOf(problem[0]);

        for(int i = 1; i < length; ++i) {
            String operator = problem[i];
            if("@".equals(operator)) {
                sol *= 3;
            }
            else if("%".equals(operator)) {
                sol += 5;
            }
            else {
                sol -= 7;
            }
        }

        return sol;
    }
}