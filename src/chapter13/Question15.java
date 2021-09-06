package chapter13;

import java.util.*;

/**
 * @author kangminjung
 * @since 2021. 9. 7.
 *
 * p339 DFS/BFS - 특정 거리의 도시 찾기
 */
public class Question15 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        4 4 2 1 \n 1 2 \n 1 3 \n 2 3 \n 2 4
//        4 3 2 1 \n 1 2 \n 1 3 \n 1 4
//        4 4 1 1 \n 1 2 \n 1 3 \n 2 3 \n 2 4
        int N = s.nextInt();  // 도시의 개수
        int M = s.nextInt();  // 도로의 개수
        int K = s.nextInt();  // 거리 정보
        int X = s.nextInt();  // 출발 도시의 번호

//        출발 도시 X 에서 1만큼 이동하여 도착할 수 있는 도시들을 리스트 형식으로 저장 ex. [1 → 2, 3] & [2 → 3, 4]
        List<List<Integer>> graph = new ArrayList<>();
        int[] d = new int[300000];

//        도시 초기화. N개의 도시에서 출발하여 도착할 수 있는 도시 리스트 & 모든 도시는 가본적이 없다는 뜻은 -1 로 설정
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

//        출발 도시와 도착 도시 정보를 명시적으로 저장 ex. 리스트의 가장 첫번째는 인덱스 0이지만, 도시가 1부터 시작하므로 알아보기 쉽게 1번 도시에 2와 3을 리스트 형식으로 추가
        for (int i = 0; i < M; i++) {
            int start = s.nextInt();
            int end = s.nextInt();
            graph.get(start).add(end);
        }

//        X → X 는 0으로 설정
        d[X] = 0;

//        가까운 노드부터 탐색하는 너비우선탐색 (BFS) 는 큐 방식 이용
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        while (!q.isEmpty()) {
            int now = q.poll();

//            큐에서 꺼낸 출발 도시에서 도착 도시만큼 찾아서 가보지 않은 도시라면 +1
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                if (d[next] == -1) {
                    d[next] = d[now] + 1;
                    q.offer(next);
                }
            }
        }

//        최단 거리 도시가 없는 값으로 초기 설정
        boolean check = false;
//        도시 1부터 거리가 K 인 도착 도시가 있는지 확인
        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println("i = " + i);
                check = true;
            }
        }

        if (!check) {
            System.out.println("i = " + -1);
        }
    }
}
