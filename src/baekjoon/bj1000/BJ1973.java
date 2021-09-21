package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//욕심쟁이 판다
public class BJ1973 {
//	static class Bamboo {
//		int x, y, amount;
//		Bamboo(int x, int y, int amount) {
//			this.x = x;
//			this.y = y;
//			this.amount = amount;
//		}
//	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] forest, cache;	//forest = 대나무숲, cache[i][j] = 판다가 (i,j)에서 먹기시작했을때 가장 오래 살아남은 일수
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		forest = new int[N][N];
		cache = new int[N][N];
//		List<Bamboo> bambooList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int amount = Integer.parseInt(st.nextToken());
				forest[i][j] = amount;
//				bambooList.add(new Bamboo(i, j, amount));
			}
		}
		
//		Collections.sort(bambooList, (a, b) -> a.amount - b.amount);	//대나무수가 가장 적은 곳부터 시작하여 검사하는게 더 오래걸렸다. 정렬할 필요가 없었음.
//		
//		int result = 0;
//		for(Bamboo bamboo : bambooList) {
//			if(cache[bamboo.x][bamboo.y] == 0) {
//				solve(bamboo.x, bamboo.y);
//			}
//			result = Math.max(result, cache[bamboo.x][bamboo.y]);
//		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cache[i][j] == 0) {	//아직 캐싱이 안됐으면 탐사.
					solve(i, j);
				}
				result = Math.max(result, cache[i][j]);	//가장 오래 살아남는 일수.
			}
		}
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int x, int y) {
		
		if(cache[x][y] != 0) {	//이미 (x,y)에서 시작하여 오래살아남은 일수를 안다면 바로 리턴.
			return cache[x][y];
		}
		
		cache[x][y] = 1;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < N) && forest[x][y] < forest[nx][ny]) {
				cache[x][y] = Math.max(cache[x][y], solve(nx, ny) + 1);		//상하좌우에서 현재위치 대나무 갯수보다 많은 곳들 중 가장 오래 살아남은 일수 + 1이 현재위치서 시작하여 가장 오래 살아남는 일수다.
			}
		}
		return cache[x][y];
	}
}
