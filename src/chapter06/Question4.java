package chapter06;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author kangminjung
 * @since 2021. 9. 13.
 *
 * p182 - 두 배열의 원소 교체
 */
public class Question4 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 5, 4, 3};
        Integer[] B = new Integer[]{5, 5, 6, 6, 5};
        int K = 3;

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int[] temp = new int[A.length];
        for (int i = 0; i < K; i++) {
            temp[i] = A[i];
            A[i] = B[i];
            B[i] = temp[i];
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i];
        }

        System.out.println("result = " + result);
    }
}
