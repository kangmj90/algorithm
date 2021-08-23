package chapter03;

import java.util.Arrays;

/**
 * @author kangminjung
 * @since 2021. 8. 24.
 *
 * p92 큰 수의 법칙
 */
public class Question2 {
    public static void main(String[] args) {
//        배열의 크기
        int n = 5;
//        int[] arr = new int[]{2, 4, 5, 4, 6};
        int[] arr = new int[]{3, 4, 3, 4, 3};
//        숫자가 더해지는 횟수
//        int m = 8;
        int m = 7;
//        연속해서 더해질 수 있는 수
//        int k = 3;
        int k = 2;

        Arrays.sort(arr);

        int first = arr[n - 1];
        int second = arr[n - 2];

        int cnt = (m / k) * k;

        int result = (cnt * first) + ((m - cnt) * second);

        System.out.println("result = " + result);
    }
}
