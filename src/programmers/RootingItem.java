package programmers;

//아이템 줍기
public class RootingItem {
    public static void main(String[] args) {
        int[][][] rectangles = {
                {
                        {1, 1, 7, 4},
                        {3, 2, 5, 5},
                        {4, 3, 6, 9},
                        {2, 6, 8, 8},
                },
                {
                        {1, 1, 8, 4},
                        {2, 2, 4, 9},
                        {3, 6, 9, 8},
                        {6, 3, 7, 7},
                },
                {
                        {1, 1, 5, 7},
                },
                {
                        {2, 1, 7, 5},
                        {6, 4, 10, 10},
                },
                {
                        {2, 2, 5, 5},
                        {1, 3, 6, 4},
                        {3, 1, 4, 6},
                },
        };

        int[] characterXs = {1, 9, 1, 3, 1};
        int[] characterYs = {3, 7, 1, 1, 4};
        int[] itemXs = {7, 6, 4, 7, 6};
        int[] itemYs = {8, 1, 7, 10, 3};

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println(solution(rectangles[i], characterXs[i], characterYs[i], itemXs[i], itemYs[i]));
        }
    }

    static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        //점 사이를 선으로 이어 길이를 알아야 하므로 직사각형 크기를 두배로 늘려서 점 사이간 길이 계산이 쉽도록 한다.
        int[][] ground = new int[102][102];

        for (int[] arr : rectangle) {
            for (int i = arr[0] * 2 - 1; i <= arr[2] * 2 - 1; i++) {
                for (int j = arr[1] * 2 - 1; j <= arr[3] * 2 - 1; j++) {
                    ground[i][j]++;
                }
            }
        }

        ground[characterX * 2 - 1][characterY * 2 - 1] = -1;
        answer = test(characterX * 2 - 1, characterY * 2 - 1, itemX * 2 - 1, itemY * 2 - 1, ground);
        answer /= 2;    //크기를 두배 늘렸으므로 길이도 두배 늘었다. 그러므로 2로 나눈다.

        return answer;
    }

    static int test(int x, int y, int ex, int ey, int[][] ground) {
        if (x == ex && y == ey) {   //도착점
            return 1;
        }

        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] d2 = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int result = 10002;

        for (int i = 0; i < d.length; i++) {
            int dx = x + d[i][0], dy = y + d[i][1];
            if ((ground[dx][dy] >= 1 && ground[dx][dy] <= 2) || (dx == ex && dy == ey)) {   //외곽선 후보 또는 이미 방문한 도착점인 경우에도 갈 수 있게 한다.
                boolean canMove = false;
                for(int j = 0; j < d2.length; j++) {    //상하좌우,대각선에 0인경우(외곽선인 경우)에 갈 수 있다.
                    int ddx = dx + d2[j][0], ddy = dy + d2[j][1];
                    if(ground[ddx][ddy] == 0) {
                        canMove = true;
                        break;
                    }
                }
                if(canMove) {
                    ground[dx][dy] = -1;    //방문 체크
                    result = Math.min(result, test(dx, dy, ex, ey, ground) + 1);    //최소 길이 갱신
                }
            }
        }
        return result;
    }
}
