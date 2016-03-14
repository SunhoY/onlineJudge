import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int TOTAL_LENGTH = 12;
    private static int LENGTH = 6;
    private static String directions = "";
    private static int[] distances = new int[TOTAL_LENGTH];
    private static String[] patterns = {"1414", "3131", "4242", "2323"};

    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("2477/input"));
//        Scanner sc = new Scanner(System.in);

        int fruitPerUnit = sc.nextInt();
        int k = 0;

        while(sc.hasNext()) {
            int direction = sc.nextInt();
            int distance = sc.nextInt();

            directions += String.valueOf(direction);
            distances[k + LENGTH] = distance;
            distances[k++] = distance;
        }

        directions += directions;

        int answer = 0;

        for(int i = 0; i < patterns.length; ++i) {
            int idx = directions.indexOf(patterns[i]);

            if(idx == -1) {
                continue;
            }

            int[] target = Arrays.copyOfRange(distances, idx, idx + 4);

            int small = target[1] * target[2];
            int large = (target[0] + target[2]) * (target[1] + target[3]);
            answer = (large - small) * fruitPerUnit;
        }
        System.out.println(answer);
    }
}