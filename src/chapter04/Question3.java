package chapter04;

import java.util.Scanner;

/**
 * @author kangminjung
 * @since 2021. 8. 25.
 *
 * p119 게임 개발
 */
public class Question3 {
    public static void main(String[] args) {

        int[][] map = new int[50][50];
        int[][] location = new int[50][50];

//        북, 서, 남, 동
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};

        Scanner s = new Scanner(System.in);

//        맵의 크기 (N x M)
        int n = s.nextInt();
        int m = s.nextInt();

//        위치 + 바라보는 방향
        int x = s.nextInt();
        int y = s.nextInt();
        int d = s.nextInt();    // 북:0 동:1 남:2 서:3
//        현재 위치에 이미 가본 칸으로 설정
        location[x][y] = 1;

//        바다/육지 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
            }
        }

        int result = 0;
        while (true) {

//            현재 방향에서 왼쪽으로 돌려 바라보기 (ex. 북 > 서)
            d--;
            if (d < 0) {
                d = 3;
            }

//            현재 위치에서 바라본 방향으로 이동
            int currentX = x + dx[d];
            int currentY = y + dy[d];

//            맵이 육지이고 위치가 가보지 않은 칸이라면
            if (map[currentX][currentY] == 0 && location[currentX][currentY] == 0) {
                location[currentX][currentY] = 1;
                x = currentX;
                y = currentY;

                result++;
            } else {

            }
        }
    }
}
