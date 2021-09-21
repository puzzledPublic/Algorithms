package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//육각형 우리 속의 개미
public class BJ17370 {
	static int N;
	static int result;
	static boolean[][] check = new boolean[50][50];	//22번 회전 가능하므로 (25,25)를 원점으로 잡는 50x50배열을 만든다.
	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		check[25][25] = true;	//원점 체크
		check[25][26] = true;	//처음은 무조건 북쪽으로 가니 (25,26)도 체크
		solve(0, 25, 26, 3);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	//(x, y)위치에 d방향으로 왔을때 움직이는 경우 (d = 0(동), 1(서), 2(남), 3(북))
	//동 -> 북, 동(짝) or 남, 동(홀)
	//서 -> 북, 서(짝) or 남, 서(홀)
	//북 -> 동, 서
	//남 -> 동, 서
	static void solve(int n, int x, int y, int d) {
		
		int d1 = 0, d2 = 1;
		if(d == 0 || d == 1) {	//방향이 동 or 서인 경우
			int s = x + y;
			if(s % 2 == 0) {	//좌표 (x, y)합이 짝수면 북
				d1 = 3;
			}else {				//아니면 남
				d1 = 2;
			}
			d2 = d;	//나머지 한쪽은 온 방향대로
		}
		
		int nx = x + dir[d1][0], ny = y + dir[d1][1];	//다음 방향 좌표로 백트래킹
		if(!check[nx][ny] && n < N) {
			check[nx][ny] = true;
			solve(n + 1, nx, ny, d1);
			check[nx][ny] = false;
		}else if(check[nx][ny] && n + 1 == N) {	//N번째 회전이고 다음 좌표가 체크돼있으면 조건 만족
			result++;
		}
		
		nx = x + dir[d2][0];
		ny = y + dir[d2][1];
		if(!check[nx][ny] && n < N) {
			check[nx][ny] = true;
			solve(n + 1, nx, ny, d2);
			check[nx][ny] = false;
		}else if(check[nx][ny] && n + 1 == N) {
			result++;
		}
	}
}
