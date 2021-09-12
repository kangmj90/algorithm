package chapter06;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author kangminjung
 * @since 2021. 9. 13.
 *
 * p178 위에서 아래로
 */
public class Question2 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{15, 27, 12};

        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("arr = " + Arrays.asList(arr));
    }
}
