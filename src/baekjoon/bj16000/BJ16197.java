package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//두 동전
public class BJ16197 {
	static class State {
		Pos a, b;
		int t;
		State(Pos a, Pos b, int t) {
			this.a = a;
			this.b = b;
			this.t = t;
		}
	}
	static class Pos {
		int x, y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N + 2][M + 2];	//동전이 떨어지는걸 표현하기 위해 가로 세로 1칸씩 더 늘린다.
		boolean[][][][] check = new boolean[N + 2][M + 2][N + 2][M + 2];	//체크배열
		List<Pos> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 1; j <= M; j++) {
				char ch = line.charAt(j - 1);
				if(ch == 'o') {
					list.add(new Pos(i, j));	//동전 시작 위치
				}
				board[i][j] = ch;
			}
		}
		
		int result = -1;
		
		Queue<State> queue = new LinkedList<>();
		State s = new State(list.get(0), list.get(1), 0);
		queue.add(s);
		check[s.a.x][s.a.y][s.b.x][s.b.y] = true; 
		while(!queue.isEmpty()) {	//BFS
			State state = queue.poll();
			
			if(state.t > 10) {	//10번 이상 누른 경우 종료
				break;
			}
			
			if(isOut(state.a) && isOut(state.b)) continue;	//동전 둘 다 떨어졌다면 넘어간다.
			
			if(!(!isOut(state.a) && !isOut(state.b))) {	//동전 하나만 떨어진 경우 종료.
				result = state.t;
				break;
			}
			
			for(int i = 0; i < d.length; i++) {
				int nax = state.a.x + d[i][0];
				int nay = state.a.y + d[i][1];
				int nbx = state.b.x + d[i][0];
				int nby = state.b.y + d[i][1];
				if(board[nax][nay] == '#') {	//동전이 이동 할 다음 위치가 벽인 경우 움직이지 않는다.
					nax = state.a.x;
					nay = state.a.y;
				}
				if(board[nbx][nby] == '#') {
					nbx = state.b.x;
					nby = state.b.y;
				}
				
				if(!check[nax][nay][nbx][nby]) {	//시도한적 없는 곳이라면 이동.
					check[nax][nay][nbx][nby] = true;
					queue.add(new State(new Pos(nax, nay), new Pos(nbx, nby), state.t + 1));
				}
				
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean isOut(Pos p) {
		return p.x == 0 || p.y == 0 || p.x == N + 1 || p.y == M + 1;
	}
}
