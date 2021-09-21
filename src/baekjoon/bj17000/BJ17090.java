package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//미로 탈출하기
public class BJ17090 {
	static int N, M;
	static char[][] maze;
	static int[][] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze= new char[N][];
		chk = new int[N][M];
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				chk[i][j] = -1;	//dp배열 초기화
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				result += solve(i, j);	//모든 위치에서 탐색 시도.
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int solve(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) {	//탈출한 경우 1을 리턴해 경로를 모두 1로 만든다.
			return 1;
		}
		
		if(chk[x][y] != -1) {	//Memoization
			return chk[x][y];
		}
		
		chk[x][y] = 0;	//경로 방문 표시
		
		//다음 위치로 이동.
		if(maze[x][y] == 'U') chk[x][y] = solve(x - 1, y);
		if(maze[x][y] == 'D') chk[x][y] = solve(x + 1, y);
		if(maze[x][y] == 'R') chk[x][y] = solve(x, y + 1);
		if(maze[x][y] == 'L') chk[x][y] = solve(x, y - 1);
		
		return chk[x][y];
	}
}

/* 위의 풀이보다 복잡하지만 조금 더 효율적인 코드.
public class BJ17090 {
	static int N, M;
	static char[][] maze;
	static char[][] canEscape;
	static boolean success;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][];	//미로
		canEscape = new char[N][M];	//canEscape[i][j] = (i, j)에서 시작해서 탈출 할 수 있는가?
		
		for(int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				canEscape[i][j] = 'P';	//'P'로 두어 탐색해야 함을 나타낸다.
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				success = true;	//(i, j)에서 시작하여 탈출 가능한지 여부
				if(canEscape[i][j] == 'P') {	//'P'인 경우 탐색해본다.
					solve(i, j);
					if(success) {	//탐색이 성공이라면 결과 증가.
						result++;
					}
				}else if(canEscape[i][j] == 'Y') {	//'P'가 아닌 경우 탐색할 필요 없고 'Y'인 경우 결과 증가
					result++;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int x, int y) {	//dfs로 경로 탐사.
		canEscape[x][y] = 'T';	//현재 지나는 경로를 'T'로 둔다.
		int nx = x, ny = y;	//다음 위치.
		switch(maze[x][y]) {
		case 'U':
			nx -= 1;
			break;
		case 'R':
			ny += 1;
			break;
		case 'D':
			nx += 1;
			break;
		case 'L':
			ny -= 1;
			break;
		}
		if((0 <= nx && nx < N) && (0 <= ny && ny < M)) {	//다음 위치가 미로 밖이 아닌 경우
			if(canEscape[nx][ny] == 'P') {	//'P'인 경우 더 갈 수 있다.
				solve(nx, ny);
				if(!success) {	//백트래킹. 탈출 실패의 경우 경로를 되돌아가며 'N'으로 만든다.
					canEscape[x][y] = 'N';
				}else {	//성공이라면 경로를 되돌아가며 'Y'로 만든다.
					canEscape[x][y] = 'Y';
				}
			}else if(canEscape[nx][ny] == 'T' || canEscape[nx][ny] == 'N') {	//'T'이거나 'N'이면 사이클이 생기므로 탈출 실패.
				canEscape[x][y] = 'N';
				success = false;
			}else {	//그 외의 경우 'Y'
				canEscape[x][y] = 'Y';
			}
		}else {	//다음 위치가 미로 밖인 경우
			canEscape[x][y] = 'Y';	//탈출이므로 'Y'로 만든다.
		}
	}
}
*/