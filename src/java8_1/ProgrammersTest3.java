package java8_1;

//프로그래머스 2018 하반기 모의고사
//버스 여행
public class ProgrammersTest3 {
	public static void main(String[] args) {
		int n = 3;
		int[][] signs = {
				{0,1,0},{0,0,1},{1,0,0}
		};
		solve(n, signs);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(signs[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	static int[][] solve(int n, int[][] signs) {
		int[][] answer;
		
		for(int k = 0; k < n; k++) {	//플로이드 와샬
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(signs[i][k] == 1 && signs[k][j] == 1) {
						signs[i][j] = 1;
					}
				}
			}
		}
		
		return answer = signs;
	}
}
