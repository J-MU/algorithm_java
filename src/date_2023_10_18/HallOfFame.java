package date_2023_10_18;

// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// 우선순위 큐를 사용하면 되지 않을까?

import java.util.*;

public class HallOfFame {

    public static void main(String[] args) {
        int[] scores = {10, 100, 20, 150, 1, 100, 200};
        int[] scores2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println("solution(3,scores) = " + solution(3, scores));
        System.out.println("solution(3,scores) = " + solution(4, scores2));
    }

    private static int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int i = 0; i < scores.length; i++) {
            integers.add(scores[i]);

            if (integers.size() > k) {
                integers.poll();
            }

            answer[i] = integers.peek();
        }

        return answer;
    }

}
