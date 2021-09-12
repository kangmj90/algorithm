package chapter06;

import java.util.*;

/**
 * @author kangminjung
 * @since 2021. 9. 13.
 *
 * p180 성적이 낮은 순서로 학생 출력하기
 */
public class Question3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            String name = s.next();
            int score = s.nextInt();

            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < N; i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }

    private static class Student implements Comparable<Student>{
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }

        @Override
        public int compareTo(Student o) {
            if (this.score < o.score) {
                return -1;
            }

            return 1;
        }
    }
}
