package chapter05;

/**
 * @author kangminjung
 * @since 2021. 8. 31.
 *
 * p149 음료수 얼려 먹기
 */
public class Question3 {
//        얼음 틀 크기 가로 x 세로
    static int n = 4;
    static int m = 5;

    //        얼음 틀의 고정 크기 가로 x 세로
    static int[][] graph = new int[1000][1000];

    public static void main(String[] args) {
        graph = new int[][]{{0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println("result = " + result);
    }

//    dfs 는 스택 자료구조 혹은 재귀함수 이용
    public static boolean dfs(int row, int column) {
//        얼음 틀 크기에서 벗어난 값
        if (row < 0 || column < 0 || row >= n || column >= m) {
            return false;
        }

//        다녀간 위치 확인 (다녀가지 않은 곳 / 얼음 > 0, 다녀간 곳 / 얼음 틀 > 1)
        if (graph[row][column] == 0) {
            graph[row][column] = 1;

            dfs(row - 1, column);
            dfs(row + 1, column);
            dfs(row, column - 1);
            dfs(row, column + 1);

            return true;
        }

        return false;
    }
}
