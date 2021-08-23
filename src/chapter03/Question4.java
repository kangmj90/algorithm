package chapter03;

/**
 * @author kangminjung
 * @since 2021. 8. 24.
 *
 * p99 1이 될때까지
 */
public class Question4 {
    public static void main(String[] args) {
        int n = 25;
        int k = 3;

        System.out.println("solution1 = " + soution1(n, k));
        System.out.println("solution2 = " + solution2(n, k));
    }

    private static int soution1(int n, int k) {
        int result = 0;

        while (true) {
            if (n % k == 0) {
                n /= k;
            } else {
                n--;
            }

            result++;

            if (n == 1) {
                return result;
            }
        }
    }

    private static int solution2(int n, int k) {
        int result = 0;

        while (true) {
            /**
             * n을 k로 나눌 수 있는 가장 가까운 k의 배수 계산
             * ex. n = 25 > 24, n = 8 > 6
             */
            int target = (n / k) * k;

            /**
             * n을 k의 배수로 만들기 위해 n -1 을 몇 번 실행해야 하는지 계산
             * ex. n = 25 > 25 - 24 = 1, n = 8 > 8 - 6 = 2
             */
            result += (n - target);
            n = target;

            /**
             * n이 k보다 작은 수라면 k로 나눌 수 없기 때문에 n을 1로 만들기 위해 n - 1을 몇 번 해야하는 지 계산
             * ex. n = 2 > n - 1 = 1
             */
            if (n < k) {
                return result + (n - 1);
            }

            result++;
            n /= k;
        }
    }

}
