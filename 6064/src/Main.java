import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("6064/input"));
//        Scanner sc = new Scanner(System.in);

        sc.useDelimiter(System.getProperty("line.separator"));
        int pNum = sc.nextInt();

        for (int i = 0; i < pNum; i++) {
            String[] str = sc.next().split(" ");
            int _m = Integer.valueOf(str[0]),
                    _n = Integer.valueOf(str[1]),
                    _x = Integer.valueOf(str[2]),
                    _y = Integer.valueOf(str[3]);
            int maxYear = getLcm(_m, _n);
            int maxIter = maxYear / _m;
            boolean found = false;

            for(int i_year = 0; i_year < maxIter; ++i_year) {
                int targetYear = i_year * _m + _x;

                int targetY = targetYear % _n;
                if(targetY == 0) {
                    targetY = _n;
                }

                if(targetY == _y) {
                    found = true;
                    System.out.println(i_year * _m + _x);
                }
            }
            if(!found) {
                System.out.println(-1);
            }
        }


    }

    public static int getGcd(int x, int y) {
        int high = x > y ? x : y;
        int low = x > y ? y : x;
        int remain = -1;

        while(remain != 0) {
            remain = high % low;
            high = low;
            low = remain;
        }

        return high;
    }

    public static int getLcm(int x, int y) {
        return x * y / getGcd(x, y);
    }
}