import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(new File("9933/input"));
//        Scanner sc = new Scanner(System.in);

        String[][] subjects = new String[6][100];
        int[] indices = new int[6];
        for(int i = 0; i < 6; i++) {
            indices[i] = 0;
        }

        int lineNumber = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < lineNumber; ++i) {
            String subject = sc.nextLine();
            int length = subject.length();
            int index = length / 2 - 1;

            if(isEqual(subject, subject, length)) {
                System.out.println(length + " " + subject.charAt(length / 2));
                sc.close();
                return;
            }

            subjects[index][indices[index]] = subject;
            indices[index] += 1;
        }

        for(int i = 0; i < 6; ++i) {
            if(indices[i] == 0) {
                continue;
            }

            String[] targetSubject = subjects[i];

            String result = doSomething(targetSubject, (i * 2) + 3, indices[i]);

            if(result == null) {
                continue;
            }
            else {
                System.out.println(result);
                sc.close();
                return;
            }
        }
    }

    private static String doSomething(String[] target, int stringLength, int targetLength) {
        for(int i = 0; i < targetLength; ++i) {
            String subject = target[i];

            for(int j = 0; j < targetLength; ++j) {
                if(isEqual(subject, target[j], stringLength)) {
                    return stringLength + " " + subject.charAt(stringLength / 2);
                }
            }
        }

        return null;
    }

    private static boolean isEqual(String subject, String target, int length) {
        if(subject.charAt(length / 2) != target.charAt(length / 2)) {
            return false;
        }

        for(int compare = 0; compare < length; ++compare) {
            if(subject.charAt(length - compare - 1) != target.charAt(compare)) {
                return false;
            }
        }
        return true;
    }
}