package algorithmsForPS;

import java.io.File;
import java.util.Scanner;

//격자길 L
public class AfcLatticeRoadL {
	static int N, M;	//N = 세로 크기, M = 가로 크기
	static int[][] DT;//DT[i][j] = i, j 좌표까지 도달할 수 있는 길의 갯수
	static int[][] DT2;
	static int[][] DT3;
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcLatticeRoadL";
		try(Scanner input = new Scanner(new File(path))) {
			while(input.hasNext()) {
				N = input.nextInt();
				M = input.nextInt();
				DT = new int[N + 2][M + 2];
				DT2 = new int[N + 1][M + 1];
				DT3 = new int[N + 1][M + 1];
				
				System.out.println(N + " " + M);
				System.out.println("메모이제이션(상향식) " + solve1(0, 0));
				System.out.println("메모이제이션(하향식) " + solve2(N, M));
				System.out.println("동적계획법 " + solve3());
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//메모이제이션 (상향식)
	static int solve1(int a, int b) {
		if(DT[a][b] == 0) {
			if(a > N || b > M || !available(a, b)) {	//갈 수 없는 길이라면
				DT[a][b] = 0;
			}
			else if(a == N && b == M) {	//목적지에 도착한 경우
				DT[a][b] = 1;
			}else {	//아래 or 오른쪽으로 전진
				DT[a][b] = solve1(a + 1, b) + solve1(a, b + 1);
			}
		}
		return DT[a][b];
	}
	//메모이제이션 (하향식)
	static int solve2(int a, int b) {
		if(DT2[a][b] == 0) {
			if(a == 0 && b == 0) {
				DT2[a][b] = 1;
			}else if(!available(a, b)) {
				DT2[a][b] = 0;
			}else {
				if(a - 1 >= 0) {
					DT2[a][b] += solve2(a - 1, b);
				}
				if(b - 1 >= 0) {
					DT2[a][b] += solve2(a, b - 1);
				}
			}
		}
		return DT2[a][b];
	}
	//동적계획법
	static int solve3() {
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= M; j++) {
				if(i == 0 && j == 0) {
					DT3[i][j] = 1;
				}else if(!available(i, j)) {
					DT3[i][j] = 0;
				}else {
					if(i - 1 >= 0) {
						DT3[i][j] += DT3[i - 1][j];
					}
					if(j - 1 >= 0) {
						DT3[i][j] += DT3[i][j - 1];
					}
				}
			}
		}
		return DT3[N][M];
	}
	static boolean available(int a, int b) {	//좌표 (a, b)가 격자의 대각선 아래에 있는지 검사하는 함수
		return (b == 0 || (double)N / M <= (double)a / b);
	}
}
