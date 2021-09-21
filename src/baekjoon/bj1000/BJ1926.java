package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//그림
public class BJ1926 {
	static char[][] paper;
	static int N, M;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		paper = new char[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				paper[i][j] = st.nextToken().charAt(0);
			}
		}
		int max = 0, count = 0;	//가장 큰 그림 넓이, 그림 개수
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(paper[i][j] == '1') {	//칠해진 경우('1') 탐색
					count++;	//그림 개수 증가
					int temp = dfs(i, j);
					if(max < temp) {	//가장 큰 그림 넓이 갱신
						max = temp;
					}
				}
			}
		}
		
		bw.write(count + "\n" + max);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dfs(int x, int y) {	//그림 넓이 반환
		paper[x][y] = '0';	//방문체크
		int result = 1;
		for(int i = 0; i < 4; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < M) && paper[nx][ny] == '1') {	//상하좌우를 살펴 탐색
				result += dfs(nx, ny);
			}
		}
		return result;
	}
}
