package programmers;

import java.util.Arrays;

//풍선 터뜨리기
public class PopABalloon {
    public static void main(String[] args) {
        int[][] as = {
                {9, -1, -5},
                {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33},
        };

        for (int i = 0; i < as.length; i++) {
            System.out.println(solution(as[i]));
        }
    }

    static int solution(int[] a) {
        int answer = 0;

        int[] left = new int[a.length]; //left[i] = a[i] 왼쪽의 원소들 중 가장 숫자가 작은 풍선
        int[] right = new int[a.length];    //right[i] = a[i] 오른쪽의 원소들 중 가장 숫자가 작은 풍선

        left[0] = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            left[i] = Math.min(left[i - 1], a[i - 1]);
        }

        right[a.length - 1] = Integer.MAX_VALUE;
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], a[i + 1]);
        }

        for (int i = 0; i < a.length; i++) {
            if (!(a[i] > left[i] && a[i] > right[i])) { //a[i]보다 양쪽의 최소 풍선 숫자가 더 작은 경우 지울 수 없는 풍선
                answer++;
            }
        }

        return answer;
    }
}
