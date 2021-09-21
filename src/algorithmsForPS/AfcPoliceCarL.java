package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

//경찰차 L
public class AfcPoliceCarL {
	static int N, M;
	static int[][] cases;
	static int[][] DT;
	static int[][] DT2;
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcPoliceCarL";
		
		try(Scanner input = new Scanner(new File(path))) {
			while(input.hasNext()) {
				N = input.nextInt();
				M = input.nextInt();
				cases= new int[M + 2][2];
				DT = new int[M + 2][M + 2];
				DT2 = new int[M + 2][M + 2];
				for(int i = 2; i < M + 2; i++) {
					cases[i][0] = input.nextInt();
					cases[i][1] = input.nextInt();
				}
				cases[0][0] = cases[0][1] = 1;	//0번째, 1번째 사건은 최초 경찰차 위치로 한다.
				cases[1][0] = cases[1][1] = N;
				System.out.println(solve1(0, 1));
				System.out.println(solve2());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	//메모이제이션
	static int solve1(int a, int b) {	//Max(a, b)번째 사건을 처리하고 첫번째 경찰차는 사건 a위치, 두번째 경찰차는 사건 b의 위치에 있을때 두 경찰차가 이동한 최소 거리
		if(DT[a][b] == 0) {
			int next = (a > b ? a : b) + 1;
			if(next >= M + 2) {
				DT[a][b] = 0;
			}else {
				DT[a][b] = Math.min(solve1(next, b) + dist(a, next), solve1(a, next) + dist(b, next));
			}
		}
		return DT[a][b];
	}
	//동적계획법
	static int solve2() {
		for(int i = 0; i < M + 2; i++) {
			for(int j = 0; j < M + 2; j++) {
				DT2[i][j] = 10000000;
			}
		}
		DT2[0][1] = 0;
		for(int i = 0; i < M + 2; i++) {
			for(int j = 1; j < M + 2; j++) {
				if(i == j) {
					DT2[i][j] = 987654321;
				}else if(i > j) {
					if(i - 1 > j) {
						DT2[i][j] = DT2[i - 1][j] + dist(i - 1, i); 
					}else {
						for(int k = 0; k < j; k++) {
							DT2[i][j] = Math.min(DT2[i][j], DT2[k][j] + dist(k, i));
						}
					}
				}else{
					if(j - 1 > i) {
						DT2[i][j] = DT[i][j - 1] + dist(j - 1, j);
					}else {
						for(int k = 1; k < i; k++) {
							DT2[i][j] = Math.min(DT2[i][j], DT2[i][k] + dist(k, j));
						}
					}
				}
			}
		}
		int ans = 987654321;
		for(int i = 0; i < M + 2; i++) {
			ans = Math.min(ans, Math.min(DT2[i][M + 1], DT2[M + 1][i]));
		}
		return ans;
	}
	static int dist(int a, int b) {	//a사건과 b사건의 거리를 구하는 함수
		return Math.abs(cases[a][0] - cases[b][0]) + Math.abs(cases[a][1] - cases[b][1]);
	}
}
