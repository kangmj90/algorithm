package chapter04;

/**
 * @author kangminjung
 * @since 2021. 8. 25.
 *
 * p115 왕실의 나이트
 */
public class Question2 {
    public static void main(String[] args) {
//        1. 수평으로 2칸 + 수직으로 1칸
//        2. 수직으로 2칸 + 수평으로 1칸

        int[] dx = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
        int[] dy = new int[]{-1, 1, -1, 1, 2, -2, 2, -2};

//        String input = "a1";
        String input = "c2";
//        입력된 문자열이 열행 순서이기 때문에 행열로 바꿔서 문자를 숫자형태로 바꾸기
//        문자형 숫자 - '0' = 숫자 / 문자 - 'a' + 1 = 문자의 순서 (ex. a = 1, b = 2, c = 3 ....)
        int row = input.charAt(1) - '0';
        int column = input.charAt(0) - 'a' + 1;

        int result = 0;

        for (int i = 0; i < 8; i++) {
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];

            if (nextRow < 1 || nextRow > 8 || nextColumn < 1 || nextColumn > 8) {
                continue;
            }

            result++;
        }
        System.out.println("result = " + result);
    }
}
