package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//교점에 별 만들기
public class MakingStarOnIntersectionPoint {
    public static void main(String[] args) {
        int[][][] lines = {
                {
                        {2, -1, 4},
                        {-2, -1, 4},
                        {0, -1, 1},
                        {5, -8, -12},
                        {5, 8, 12},
                },
                {
                        {0, 1, -1},
                        {1, 0, -1},
                        {1, 0, 1},
                },
                {
                        {1, -1, 0},
                        {2, -1, 0},
                },
                {
                        {1, -1, 0},
                        {2, -1, 0},
                        {4, -1, 0},
                }
        };

        for (int[][] line : lines) {
            Arrays.stream(solution(line)).forEach(r -> System.out.println(r));
            System.out.println();
        }
    }

    static String[] solution(int[][] line) {
        String[] answer = {};

        List<int[]> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
        for (int i = 0; i < line.length - 1; i++) { //두개의 점에 대해 교점을 탐색.
            int A = line[i][0], B = line[i][1], C = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                int D = line[j][0], E = line[j][1], F = line[j][2];
                int m1 = (B * F - C * E), m2 = (A * E - B * D);
                int n1 = (A * F - C * D), n2 = (B * D - A * E);

                if(m2 != 0 && m1 % m2 == 0 && n1 % n2 == 0) {   //교차하는 경우, 정수인 경우만 탐색
                    int x = m1 / m2;
                    int y = n1 / n2;

                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);

                    list.add(new int[]{x, y});
                }
            }
        }

        char[][] arr = new char[maxX - minX + 1][maxY - minY + 1];
        for(int i = 0; i < arr.length; i++) {   //출력할 배열 초기화.
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '.';
            }
        }

        for(int[] l : list) {   //교점 표시
            arr[l[0] - minX][l[1] - minY] = '*';
        }

        String[] results = new String[arr[0].length];
        for(int i = arr[0].length - 1; i >= 0; i--) {   //출력
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < arr.length; j++) {
                str.append(arr[j][i]);
            }
            results[arr[0].length - 1 - i] = str.toString();
        }

        return answer = results;
    }

}
