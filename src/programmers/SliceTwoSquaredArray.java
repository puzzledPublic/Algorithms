package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//n^2 배열 자르기
public class SliceTwoSquaredArray {
    public static void main(String[] args) {
        int[] ns = {3, 4, 1};
        int[] lefts = {2, 7, 0};
        int[] rights = {5, 14, 0};

        for(int i = 0; i < ns.length; i++) {
            Arrays.stream(solution(ns[i], lefts[i], rights[i])).forEach(r -> System.out.print(r + " "));
            Arrays.stream(solution2(ns[i], lefts[i], rights[i])).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution(int n, long left, long right) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int leftRow = (int)(left / n) + 1;
        int leftCol = (int)(left % n) + 1;
        int rightRow = (int)(right / n) + 1;
        int rightCol = (int)(right % n) + 1;
        //배열에 수를 채우는 방식을 참고하면 ((row, col)이 (1, 1)부터 시작이라고 가정)
        //row <= col일때 arr[row][col]은 row이고 그 외의 경우 arr[row][col] = col이다.
        if(leftRow == rightRow) {   //시작과 끝이 같은 Row일때
         for(int i = leftCol; i <= rightCol; i++) {
             if(i <= leftRow) {
                 list.add(leftRow);
             }else {
                 list.add(i);
             }
         }
        }else {
            for (int i = leftCol; i <= n; i++) {    //첫 Row
                if (i <= leftRow) {
                    list.add(leftRow);
                } else {
                    list.add(i);
                }
            }
            for (int i = leftRow + 1; i < rightRow; i++) {  //중간 Row
                for (int j = 1; j <= n; j++) {
                    if (j <= i) {
                        list.add(i);
                    } else {
                        list.add(j);
                    }
                }
            }
            for (int i = 1; i <= rightCol; i++) {   //끝 Row
                if (i <= rightRow) {
                    list.add(rightRow);
                } else {
                    list.add(i);
                }
            }
        }

        return answer = list.stream().mapToInt(a -> a).toArray();
    }
    
    //left ~ right에서 각 row, col를 계산하는 방식
    static int[] solution2(int n, long left, long right) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for(long i = left; i <= right; i++) {
            int row = (int)(i / n) + 1;
            int col = (int)(i % n) + 1;

            list.add(row >= col ? row : col);
        }

        return answer = list.stream().mapToInt(a -> a).toArray();
    }
}
