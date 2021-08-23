package chapter07;

import java.util.Arrays;

/**
 * @author kangminjung
 * @since 2021. 8. 21.
 *
 * p197 부품 찾기
 */
public class Question2BinarySearch {
    public static void main(String[] args) {

//        가게의 부품 번호
        int n = 5;
        int[] arr = new int[]{8, 3, 7, 9, 2};
//        손님이 요청한 부품 번호
        int m = 3;
        int[] targets = new int[]{5, 7, 9};

        Arrays.sort(arr);

        String result = "";

        for (int i = 0; i < m; i++) {

            int start = 0;
            int end = n - 1;

            int target = targets[i];

            result += binarySearch(n, arr, start, end, target);
        }

        System.out.println("result = " + result);
    }

    private static String binarySearch(int n, int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            for (int j = 0; j < n; j++) {
                if (arr[mid] == target) {
                    return "yes ";
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return "no ";
    }
}
