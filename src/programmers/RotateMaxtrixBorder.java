package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//행렬 테두리 회전하기
public class RotateMaxtrixBorder {
    public static void main(String[] args) {
        int[] rowss = {6, 3, 100};
        int[] columnss = {6, 3, 97};
        int[][][] queriess = {
                {
                        {2, 2, 5, 4},
                        {3, 3, 6, 6},
                        {5, 1, 6, 3},
                },
                {
                        {1, 1, 2, 2},
                        {1, 2, 2, 3},
                        {2, 1, 3, 2},
                        {2, 2, 3, 3},
                },
                {
                        {1, 1, 100, 97},
                },
        };

        for(int i = 0; i < rowss.length; i++) {
            Arrays.stream(solution(rowss[i], columnss[i], queriess[i])).forEach((r) -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int idx = 1;
        int[][] arr = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = idx++;
            }
        }

        List<Integer> minList = new ArrayList<>();
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //오른쪽 -> 아래 -> 왼쪽 -> 위
        for(int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int currX = x1, currY = y1; //현재 위치
            int prev, curr; //이전 위치 값, 현재 위치 값.
            prev = curr = arr[x1][y1];
            int min = prev;
            for(int i = 0; i < d.length; i++) {
                //같은 방향으로 진행하다 사각형 범위를 넘어서면 방향 전환
                while((x1 <= currX + d[i][0] && currX + d[i][0] <= x2) && (y1 <= currY + d[i][1] && currY + d[i][1] <= y2)) {
                    currX = currX + d[i][0];
                    currY = currY + d[i][1];
                    curr = arr[currX][currY];   //현재 값 임시 저장.
                    arr[currX][currY] = prev;   //이전 값을 현재 위치로 이동
                    prev = curr;    //저장한 현재 값을 이전 값으로 임시 저장
                    min = Math.min(min, prev);
                }
            }
            minList.add(min);   //해당 쿼리의 최소값 저장
        }

        answer = minList.stream().mapToInt(a -> a).toArray();

        return answer;
    }
}
