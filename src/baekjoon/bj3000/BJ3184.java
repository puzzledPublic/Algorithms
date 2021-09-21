package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//양
public class BJ3184 {
	static int R, C, sheep, wolf;
	static char[][] yard;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		yard = new char[R][];
		
		for(int i = 0; i < R; i++) {
			yard[i] = br.readLine().toCharArray();
		}

		int sCount = 0, wCount = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sheep = 0;
				wolf = 0;
				if(yard[i][j] != 'X' && yard[i][j] != '#') {
					dfs(i, j);
					if(sheep <= wolf) {	//늑대 숫자가 양보다 같거나 많으면 늑대가 살아남는다
						wCount += wolf;
					}else {	//양의 숫자가 더 많다면 양이 살아남는다.
						sCount += sheep;
					}
				}
			}
		}
		
		bw.write(sCount + " " + wCount + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void dfs(int x, int y) {
		if(yard[x][y] == 'v') {	//늑대가 있다면 늑대 숫자 증가.
			wolf++;
		}else if(yard[x][y] == 'o'){	//양이 있다면 양 숫자 증가.
			sheep++;
		}
		yard[x][y] = 'X';	//방문 체크
		
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < R) && (0 <= ny && ny < C) && (yard[nx][ny] != 'X' && yard[nx][ny] != '#')) {
				dfs(nx, ny);
			}
		}
	}
}
