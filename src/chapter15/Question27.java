package chapter15;

/**
 * @author kangminjung
 * @since 2021. 9. 7.
 *
 * p367 이진 탐색 - 정렬된 배열에서 특정 수의 개수 구하기 (OlogN)
 */
public class Question27 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3};
        int x = 2;
//        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
//        int x = 4;

        int start = 0;
        int end = arr.length - 1;

        int left = left(arr, x, start, end);
        int right = right(arr, x, start, end);

        int result = right - left;
        if (result == 0) {
            System.out.println("result = " + (-1));
        } else {
            System.out.println("result = " + (right - left));
        }
    }

    private static int left(int[] arr, int x, int start, int end) {
//        왼쪽 끝 값 찾기
        while (start < end) {
//            배열의 중간에서 탐색 시작
            int mid = (start + end) / 2;

//            배열의 중간 값이 찾는 값보다 작을 경우 시작점을 오른쪽으로 한 칸 이동, 같거나 클 경우 끝점을 중간 인덱스로 이동
            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private static int right(int[] arr, int x, int start, int end) {
//        오른쪽 끝 값 찾기
        while (start < end) {
//            배열의 중간에서 탐색 시작
            int mid = (start + end) / 2;

//            배열의 중간 값이 찾는 값보다 클 경우 끝점을 중간 인덱스로 이동, 같거나 작을 경우 시작점을 오른쪽으로 한 칸 이동
            if (arr[mid] > x) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
