package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//치즈
public class BJ2638 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] paper;	//치즈가 올려진 모눈종이
	static int zero;	//치즈가 아닌 1x1 종이의 갯수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		paper = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0, p = 2;	//time = 치즈가 없어지는 시간, p = 한 시간에 없어지는 치즈를 구별하기위한 숫자
		fill(0, 0, p);	//먼저 치즈 외부의 종이를 체크한다.(내부 종이와 구별 할 수 있어짐)
		while(zero < N * M) {	//1x1종이가 모눈종이 크기만큼되면 종료
			for(int i = 1; i < N - 1; i++) {
				for(int j = 1; j < M - 1; j++) {
					if(paper[i][j] == 1) {	//치즈라면
						int count = 0;
						for(int k = 0; k < d.length; k++) {	//2개 이상의 인접한면이 외부와 맞닿는지 검사
							int nx = i + d[k][0], ny = j + d[k][1];
							if(2 <= paper[nx][ny] && paper[nx][ny] <= p) {	//해당위치 식별자가 2 ~ p 사이라면 외부 공기다.
								count++;
							}
						}
						if(count > 1) {
							fill(i, j, p + 1);	//해당 치즈 위치부터 dfs를 돌며 식별자를 p + 1로 채운다.
						}
					}
				}
			}
			time++;	//모눈 종이를 한번 다 돌았으므로 1시간 증가
			p++;
		}
		bw.write(time + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void fill(int x, int y, int p) {	//종이 부분만 탐색하며 체크
		paper[x][y] = p;
		zero++;	//1x1 종이칸의 갯수 증가
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < paper.length) && (0 <= ny && ny < paper[0].length) && paper[nx][ny] == 0) {
				fill(nx, ny, p);
			}
		}
	}
}
