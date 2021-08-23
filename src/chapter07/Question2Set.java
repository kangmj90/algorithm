package chapter07;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kangminjung
 * @since 2021. 8. 23.
 */
public class Question2Set {
    public static void main(String[] args) {

//        가게의 부품 번호
        int n = 5;
        int[] arr = new int[]{8, 3, 7, 9, 2};
//        손님이 요청한 부품 번호
        int m = 3;
        int[] targets = new int[]{5, 7, 9};

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        String result = "";
        for (int i = 0; i < m; i++) {
            if (set.contains(targets[i])) {
                result += "yes ";
                continue;
            }
            result += "no ";
        }

        System.out.println("result = " + result);
    }
}
