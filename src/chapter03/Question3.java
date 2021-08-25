package chapter03;

import java.util.Scanner;

/**
 * @author kangminjung
 * @since 2021. 8. 25.
 *
 * p96 숫자 카드 게임
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        행의 개수 1 <= n <= 100
        int n = s.nextInt();
//        열의 개수 1 <= m <= 100
        int m = s.nextInt();

        int result = 0;
//        1 <= 숫자 <= 10000
        for (int i = 0; i < n; i++) {
            int min = 10001;

            for (int j = 0; j < m; j++) {
                int number = s.nextInt();

//                if (number < min) {
//                    min = number;
//                }
                min = Math.min(min, number);
            }

//            if (result < min) {
//                result = min;
//            }
            result = Math.max(min, result);
        }

        System.out.println("result = " + result);
    }
}
