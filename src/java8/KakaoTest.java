package java8;

import java.util.Queue;

public class KakaoTest {
	static int[][] arr = new int[100001][4];
	public static void main(String[] args) {

		int arr[][] = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(solution(arr));
	}
	
	/*//문제5번 성공
	public static int solution(int[][] land){
		int answer = 0;
		int h = land.length - 1;
		
		for(int y = h - 1; y >= 0; y--){
			for(int x = 0; x < land[0].length; x++){
				int temp = land[y+1][x];
				land[y+1][x] = 0;
				land[y][x] += maxInRow(land[y+1]);
				land[y+1][x] = temp;
			}
		}
		
		answer = maxInRow(land[0]);
		return answer;
	}
	static int maxInRow(int[] row){
		int ret = -1;
		for(int i = 0 ; i < row.length; i++){
			ret = Math.max(ret, row[i]);
		}
		return ret;
	}*/
	
	
	//문제5번 효율성테스트 실패
	/*public static int solution(int[][] land) {
        int answer = 0;
        for(int i = 0 ; i < 4; i++){
        	answer= Math.max(answer, recur(land, i, 0));
        }
        return answer;
    }
	static int recur(int[][] land, int current, int h){
		if(h == land.length - 1){
			return land[h][current]; 
		}
		if(arr[h][current] != 0){
			return arr[h][current];
		}
		int temp = 0;
		for(int i = 0 ; i < 4; i++){
			if(i != current){
				temp = Math.max(recur(land, i, h+1), temp); 
			}
		}
		return arr[h][current] = temp + land[h][current];
	}*/
	
	//문제4번 timeout 1개(아마 케이스가 잘못된듯?) 나머지 성공 (DP)
	public static int solution(int[][] board){
		int[][] dp = new int[1001][1001];
		int answer = -1;
		
		for(int i = 1; i <= board.length; i++){
			for(int j = 1; j <= board[0].length; j++){
				if(board[i-1][j-1] == 1){
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
					answer = Math.max(dp[i][j], answer); 
				}
			}
		}
		
		return answer*answer;
	}
	
	//문제4번 TimeOut 1개, 효율성테스트 실패
	/*public static int solution(int[][] board) {
		int answer = 1234;
		int y = board.length;
		int x = board[0].length;
		int line = Math.min(y, x);
		int count = 0;
		while (answer == 1234) {
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (board[i][j] == 0) {
						continue;
					}
					if (i + line > y || j + line > x) {
						break;
					}
					for (int k = i; k < i + line; k++) {
						for (int u = j; u < j + line; u++) {
							if (board[k][u] == 1) {
								count++;
							}
						}
					}
					if (count == line * line) {
						answer = count;
					}
					count = 0;
				}
			}
			line--;
		}

		return answer;
	}*/
}
