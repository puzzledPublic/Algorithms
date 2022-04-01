package programmers;

import java.util.*;

//거리두기 확인하기
public class DistanceCheck {
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Arrays.stream(solution(places)).forEach(r -> System.out.print(r + " "));
    }

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static int[] solution(String[][] places) {
        int[] answer = {};
        int placeIndex = 0;

        answer = new int[places.length];
        Arrays.fill(answer, 1);

        for(String[] place : places) {
            int height = place.length;
            int width = place[0].length();
            char[][] chPlace = new char[height][];

            for(int i = 0; i < height; i++) {   //String을 char 배열로 쪼개기
                chPlace[i] = place[i].toCharArray();
            }

            List<Coord> personPos = new ArrayList<>();  //사람이 있는 곳 좌표 구하기
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < height; j++) {
                    if(chPlace[i][j] == 'P') {
                        personPos.add(new Coord(i, j, 0));
                    }
                }
            }

            for(Coord person : personPos) { //각 사람이 있는 곳에서 bfs
                boolean[][] checkArr = new boolean[height][width];
                Queue<Coord> queue = new LinkedList<>();
                queue.add(person);
                checkArr[person.x][person.y] = true;
                while(!queue.isEmpty()) {
                    Coord curr = queue.poll();

                    //거리가 2이하인 사람을 만나는 경우 거리두기 못하는 상황
                    if(chPlace[curr.x][curr.y] == 'P' && 0 < curr.dist && curr.dist <= 2) {
                        answer[placeIndex] = 0; //거리두기 실패 표시
                        break;
                    }

                    for(int i = 0; i < dir.length; i++) {
                        int nextX = curr.x + dir[i][0];
                        int nextY = curr.y + dir[i][1];
                        if((0 <= nextX && nextX < height) && (0 <= nextY && nextY < width)) {
                            if(chPlace[nextX][nextY] != 'X' && checkArr[nextX][nextY] == false) {
                                queue.add(new Coord(nextX, nextY, curr.dist + 1));
                                checkArr[nextX][nextY] = true;
                            }
                        }
                    }
                }
            }
            placeIndex++;
        }

        return answer;
    }

    static class Coord {
        int x, y, dist;
        Coord(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
