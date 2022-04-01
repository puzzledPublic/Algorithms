package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//빛의 경로 사이클
public class PathOfLightCycle {
    public static void main(String[] args) {
        String[][] grids = {
                {"SL", "LR"},   //16
                {"S"},  //1, 1, 1, 1
                {"R", "R"}, //4, 4
        };
        for (String[] grid : grids) {
            Arrays.stream(solution2(grid)).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
//        Arrays.stream(solution2(grids[2])).forEach(r -> System.out.print(r + " "));
//        System.out.println();
    }

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] cGrid;
    static int[][][][] arr;
    static List<Integer> result;

    //재귀로 인한 stack overflow 가능성.
    static int[] solution(String[] grid) {
        int[] answer = {};

        result = new ArrayList<>();
        cGrid = new char[grid.length][];
        for (int i = 0; i < cGrid.length; i++) {
            cGrid[i] = grid[i].toCharArray();
        }

        arr = new int[cGrid.length][cGrid[0].length][5][3];

        for (int i = 0; i < cGrid.length; i++) {
            for (int j = 0; j < cGrid[0].length; j++) {
                for (int d = 0; d < dir.length; d++) {
                    arr[i][j][d][2] = test(i, j, d, 1);
                }
            }
        }

        answer = result.stream().sorted().mapToInt(a -> a).toArray();

        return answer;
    }

    static int test(int x, int y, int d, int idx) {
        int nx = (x + dir[d][0] < 0 ? arr.length - 1 : (x + dir[d][0] >= arr.length ? 0 : x + dir[d][0]));
        int ny = (y + dir[d][1] < 0 ? arr[0].length - 1 : (y + dir[d][1] >= arr[0].length ? 0 : y + dir[d][1]));
        if (arr[nx][ny][d][0] != 0) {    //이미 방문
            if (arr[nx][ny][d][1] == 1) {    //이미 사이클까지 확인한 경우
                return arr[nx][ny][d][2];
            } else { //처음 사이클 확인 하는 경우
                arr[nx][ny][d][1] = 1;
                arr[nx][ny][d][2] = idx - arr[nx][ny][d][0];
                result.add(idx - arr[nx][ny][d][0]);
                return idx - arr[nx][ny][d][0];
            }
        }

        arr[nx][ny][d][0] = idx;
        int nd = d;
        if (cGrid[nx][ny] == 'L') {
            nd = (d + 3) % 4;
        } else if (cGrid[nx][ny] == 'R') {
            nd = (d + 1) % 4;
        }

        arr[nx][ny][d][2] = test(nx, ny, nd, idx + 1);
        arr[nx][ny][d][1] = 1;
        return arr[nx][ny][d][2];
    }

//    static String[] ddd={"우", "하", "좌", "상"};
    static int[] solution2(String[] grid) {
        int[] answer = {};

        result = new ArrayList<>();
        cGrid = new char[grid.length][];
        for (int i = 0; i < cGrid.length; i++) {
            cGrid[i] = grid[i].toCharArray();
        }

        arr = new int[cGrid.length][cGrid[0].length][5][3];

        for (int i = 0; i < cGrid.length; i++) {
            for (int j = 0; j < cGrid[0].length; j++) {
                for (int d = 0; d < dir.length; d++) {
                    int x = i, y = j, idx = 1, dd = d;
                    boolean find = false;
                    while (true) {
                        int nx = (x + dir[dd][0] < 0 ? arr.length - 1 : (x + dir[dd][0] >= arr.length ? 0 : x + dir[dd][0]));
                        int ny = (y + dir[dd][1] < 0 ? arr[0].length - 1 : (y + dir[dd][1] >= arr[0].length ? 0 : y + dir[dd][1]));
//                        System.out.println(x + " " + y + " ("+ ddd[dd] + ", " + dd + ") -> " + nx + " " + ny);
                        if (arr[nx][ny][dd][0] != 0) {    //이미 방문
                            if (arr[nx][ny][dd][1] == 1) {    //이미 사이클까지 확인한 경우
                                break;
                            } else {
                                if(!find) { //처음 사이클 확인
                                    arr[nx][ny][dd][2] = idx - arr[nx][ny][dd][0];
                                    result.add(idx - arr[nx][ny][dd][0]);
                                    find = true;
                                }else { //한번 더 돌면서 확인된 사이클 경로임을 체크
                                    arr[nx][ny][dd][1] = 1;
                                }
                            }
                        } else {
                            arr[nx][ny][dd][0] = idx;
                            idx++;
                        }

                        //다음 위치 지정
                        x = nx;
                        y = ny;
                        if (cGrid[nx][ny] == 'L') {
                            dd = (dd + 3) % 4;
                        } else if (cGrid[nx][ny] == 'R') {
                            dd = (dd + 1) % 4;
                        }
                    }
//                    System.out.println();
                }
            }
        }

        answer = result.stream().sorted().mapToInt(a -> a).toArray();

        return answer;
    }
}
