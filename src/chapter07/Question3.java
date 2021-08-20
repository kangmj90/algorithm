package chapter07;

import java.util.Scanner;

/**
 * @author kangminjeong
 * @since 2021. 8. 21.
 *
 * p201 떡볶이 떡 만들기
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        떡의 개수
//        int n = s.nextInt();
        int n = 4;
//        요청한 떡의 길이
//        int m = s.nextInt();
        int m = 6;
//        입력 받은 떡의 길이
        int[] arr = new int[n];
//        for (int i = 0; i < n ; i++) {
//            arr[i] = s.nextInt();
//        }
        arr = new int[]{19, 15, 10, 17};

        int start = 0;
        int end = 2000000000;

        int result = 0;

        while (start <= end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                if (mid < arr[i]) {
                    sum += arr[i] - mid;
                }
            }

            if (sum < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println("result = " + result);
    }
}
