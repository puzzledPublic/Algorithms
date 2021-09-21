package algorithmsForPS;

import java.util.Scanner;

//경비행기 (S)
public class AfcLightAirplane {
	static int N, K;
	static int visited[];
	static LandPlace land[];
	static int dmin = 987654321;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		
		visited = new int[N + 2];
		land = new LandPlace[N + 2];
		land[0] = new LandPlace(0, 0);
		for(int i = 1 ; i < N + 1; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			land[i] = new LandPlace(x, y);
		}
		land[N + 1] = new LandPlace(10000, 10000);
		visited[0] = 1;
		
		solve(0, 0, 0);
		
		System.out.println(Math.ceil(Math.sqrt(dmin)/10));
	}
	
	static void solve(int p, int c, int d) {	//p = 현재 랜딩 위치, c = 착지 횟수, d = 지금까지 통과한 경로에서 랜딩위치간 거리가 제일 긴 길이
		if(c == K) {
			d = Math.max(d, dist(land[p], land[N + 1]));
			if(d < dmin) {
				dmin = d;
			}
			return;
		}
		for(int i = 0; i < N + 2; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				solve(i, c + 1, Math.max(d, dist(land[p], land[i])));
				visited[i] = 0;
			}
		}
	}
	static int dist(LandPlace a, LandPlace b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
}
class LandPlace{ 
	int x, y;
	LandPlace(int x, int y) {
		this.x = x;
		this.y = y;
	}
}