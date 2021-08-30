package chapter05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author kangminjung
 * @since 2021. 8. 31.
 *
 * p152 미로 탈출
 */
public class Question4 {
//    주어진 미로의 크기 정보
    static int n = 5;
    static int m = 6;

//    미로의 고정 크기 4 <= map <= 200
    static int[][] map = new int[200][200];

//    상 하 좌 우 이동 시 변경되는 좌표
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        map = new int[][]{{1, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};

        System.out.println("result = " + bfs(0, 0));
    }

//    bfs 는 큐 자료구조 이용
    static int bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return map[n - 1][m - 1];
    }
}

// 좌표를 사용하여 갈 수 있는 곳(1) , 해당 위치를 다녀갔거나 갈 수 없는 곳(0) 으로 확인
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
