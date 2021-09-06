package chapter11;

/**
 * @author kangminjung
 * @since 2021. 9. 6.
 *
 * p313 그리디 - 문자열 뒤집기
 */
public class Question3 {
    public static void main(String[] args) {
//        String s = "0001100";
        String s = "00011001010111001000";
        int count0 = 0;
        int count1 = 0;

        if (s.charAt(0) == '0') {
            count0++;
        } else {
            count1++;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (s.charAt(i) == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        System.out.println("result = " + Math.min(count0, count1));
    }
}
