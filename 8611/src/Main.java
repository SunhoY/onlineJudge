import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    private static String NOT_FOUND = "NIE";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("8611/input"));
//        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input = sc.next();
        MathContext mc = new MathContext(0, RoundingMode.FLOOR);
        boolean globalFound = false;

        for(int i = 2; i <= 10; ++i) {
            String result = toNary(input, i);

            if(isPalindrome(result)) {
                System.out.println(i + " " + result);
                globalFound = true;
            }

            sb = new StringBuilder();
        }

        if(!globalFound) {
            System.out.println(NOT_FOUND);
        }
    }

    public static String toNary(String number, int n) {
        BigDecimal divisor = new BigDecimal(n);
        BigDecimal quotient = new BigDecimal(number);
        StringBuilder sb = new StringBuilder();
        MathContext mc = new MathContext(0, RoundingMode.FLOOR);

        while(quotient.compareTo(divisor) >= 0) {
            BigDecimal[] result = quotient.divideAndRemainder(divisor, mc);
            quotient = result[0];
            sb.append(result[1]);
        }

        if(!quotient.equals(0)) {
            sb.append(quotient);
        }

        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String number) {
        int length = number.length();
        int mid = length / 2;

        for(int i = 0; i <= mid; ++i) {
            if(number.charAt(i) != number.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;

    }
}