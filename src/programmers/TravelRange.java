package programmers;
//방문 길이
public class TravelRange {
	public static void main(String[] args) {
		//U->UP, D->DOWN, R->RIGHT, L->LEFT
		String[] dirs = {"ULURRDLLU", "LULLLLLLU", "RRRRRLLLLL"};
		for(int i = 0; i < dirs.length; i++) {
			System.out.println(solution(dirs[i]));
		}
	}
	static class Coord {
		int x, y;
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	//UP, LEFT, DOWN, RIGHT
	static int[][] d = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};	//다음에 움직일 상대적 좌표
	static int[] d2 = {0x000f, 0x0f00, 0x00f0, 0xf000};		//현재 (x,y) 위치에서 어느 방향으로부터 들어왔는지 int에 저장한다.
	static int[][] map = new int[11][11];	//좌표 평면 10x10
	static int solution(String dirs) {
        int answer = 0;
        Coord coord = new Coord(5, 5);	//(5,5)를 원점으로 한다.
        
        for(int i = 0; i < dirs.length(); i++) {
        	int nx, ny;
        	switch (dirs.charAt(i)) {
			case 'U':
				answer += subFunc(coord, 0);
				break;
			case 'D':
				answer += subFunc(coord, 2);
				break;
			case 'L':
				answer += subFunc(coord, 1);
				break;
			case 'R':
				answer += subFunc(coord, 3);
				break;
			}
        }
        
        return answer;
    }
	static int subFunc(Coord coord, int dir) {
		int result = 0;
		int nx = coord.x + d[dir][0], ny = coord.y + d[dir][1];
		if((0 <= nx && nx < 11) && (0 <= ny && ny < 11)) {
			if((map[nx][ny] & d2[dir]) == 0) {	//사용한 방향이 아니라면(처음가는 경로면)
				map[nx][ny] |= d2[dir];	//사용 표시
				//더불어 나가는 정점에서의 방향도 표시해야한다. (ex (x,y) -> (x+1,y)로 가는 경우 down인 상황이고 (x+1,y)는 down, (x,y)는 up 표시를 해야한다.)
				//(ex input="LLLLRRRR")
				//반대되는 방향의 인덱스를 쉽게 고르기 위해 위에서 정의한 d, d2배열의 방향을 up, left, down, right 순서로 놨다.
				map[coord.x][coord.y] |= d2[(dir + 2) % 4]; 
				result = 1;	//처음가는 경로이므로 +1
			}
        	coord.x = nx;	//다음 정점으로 이동
        	coord.y = ny;
		}
		return result;
	}
}
