package chapter17;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author kangminjung
 * @since 2021. 9. 7.
 *
 * p388 최단 경로 - 화성 탐사
 */
public class Question39 {
    public static void main(String[] args) {
//        int[][] graph = new int[][]{{5, 5, 4}, {3, 9, 1}, {3, 2, 7}};   // 화성 탐사 기계가 존재하는 공간 N x N
//        int[][] graph = new int[][]{{3, 7, 2, 0, 1}, {2, 8, 0, 9, 1}, {1, 2, 1, 8, 1}, {9, 8, 9, 2, 0}, {3, 6, 5, 1, 5}};
        int[][] graph = new int[][]{
                {9, 0, 5, 1, 1, 5, 3}, {4, 1, 2, 1, 6, 5, 3}, {0, 7, 6, 1, 6, 8, 5}, {1, 1, 7, 8, 3, 2, 3},
                {9, 4, 0, 7, 6, 4, 1}, {5, 8, 3, 2, 4, 8, 3}, {7, 4, 8, 4, 8, 3, 4}
        };

        int n = graph.length;
        int[][] d = new int[n][n];          // 각각의 칸을 지나기 위한 비용
        int[] dx = new int[]{-1, 0, 1, 0};  // 서 북 동 남 순서로 특정 위치에서 한칸 이동하기 위한 위치 값
        int[] dy = new int[]{0, 1, 0, -1};

//        비용 값은 최대 숫자로 초기 설정
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }

        int x = 0, y = 0;   // 맨 처음 위치는 가장 왼쪽 위 [0][0]
        // 최단 경로에서 전체 노드의 개수가 1만개 이상일 때 PriorityQueue 사용. 가장 우선 순위가 높은 데이터를 가장 먼저 삭제하는 큐
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(0, 0, graph[x][y]));
        d[x][y] = graph[x][y];

        while (!q.isEmpty()) {
            Node node = q.poll();
            int distance = node.getDistance();
            x = node.getX();
            y = node.getY();

//            이미 처리된 노드라면 무시
            if (d[x][y] < distance) {
                continue;
            }

//            현재 위치에서 상하좌우로 움직여 비용 계산
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

//                위치가 공간을 벗어나면 무시
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

//                저장된 값과 현재 위치의 값 더하기
                int cost = distance + graph[nx][ny];

//                현재 노드를 거쳐가는 비용이 다른 노드를 거쳐가는 비용보다 더 짧은 경우
                if (cost < d[nx][ny]) {
                    d[nx][ny] = cost;
                    q.offer(new Node(nx, ny, cost));
                }
            }
        }

        System.out.println("d[n - 1][n - 1] = " + d[n - 1][n - 1]);
    }

//    PriorityQueue 의 경우 Comparable implements
    static class Node implements Comparable<Node> {
        private int x;
        private int y;
        private int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getDistance() {
            return this.distance;
        }

//        거리가 짧은 노드가 우선순위
        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
}
