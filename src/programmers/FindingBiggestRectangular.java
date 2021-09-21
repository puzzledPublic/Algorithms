package programmers;
//가장 큰 직사각형 찾기 (DP)
public class FindingBiggestRectangular {
	public static void main(String[] args) {
		int[][][] board = {
				{
					{0,1,1,1},
					{1,1,1,1},
					{1,1,1,1},
					{0,0,1,0},
				},
				{
					{0,0,1,1},
					{1,1,1,1},
				},
				{
					{0}
				}
		};
		for(int i = 0; i < board.length; i++) {
			System.out.println(solution(board[i]));
		}
	}
	
	static int solution(int [][]board)
    {
		//board[i][j] = board[i][j]까지 사각형인 한변의 길이
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(i != 0 && j != 0) {
        			//[i - 1][j], [i][j - 1], [i - 1][j - 1]이 모두 1이상이고 [i][j]도 1이라면 사각형을 이룬다.
	        		if(board[i][j] >= 1 && board[i - 1][j] >= 1 && board[i][j - 1] >= 1 && board[i - 1][j - 1] >= 1) {
	        			int min = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1]));	//그중 가장 작은 변의길이 + 1이 [i][j]까지의 사각형의 길이가 된다.
	        			board[i][j] = min + 1;
	        		}
        		}
        		if(answer < board[i][j]) {	//한변의 최대 길이 
        			answer = board[i][j];
        		}
        	}
        }
        return answer * answer;		//넓이
    }
}
