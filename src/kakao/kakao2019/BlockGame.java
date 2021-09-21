package kakao.kakao2019;
//7번 블록게임
public class BlockGame {
	public static void main(String[] args) {
		int[][][] board = {
				{
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,0,0,0,0},
					{0,0,0,0,0,0,4,0,0,0},
					{0,0,0,0,0,4,4,0,0,0},
					{0,0,0,0,3,0,4,0,0,0},
					{0,0,0,2,3,0,0,0,5,5},
					{1,2,2,2,3,3,0,0,0,5},
					{1,1,1,0,0,0,0,0,0,5}
				},
				{
					{0,0,5,5,5,0,0},
					{0,0,3,5,4,0,0},
					{0,0,3,0,4,0,0},
					{0,3,3,0,4,4,0},
					{2,0,0,0,6,0,0},
					{2,0,0,0,6,0,0},
					{2,2,0,0,6,6,0}
				}
		};

		for(int i = 0; i < board.length; i++) {
			System.out.println(solution(board[i]));
		}
	}
	
	static int solution(int[][] board) {
        int answer = 0;
        int temp, count = 0;
        while(true) {
        	fillBlackBlock(board);	//검은 블록을 한줄 떨어트린다.
        	temp = removeBlock(board);	//블록을 지워본다.
        	if(temp == 0) {				
        		if(count == 2) {		//2번 검은 블록을 떨어트렸는데도 지울 수 있는게 없다면 더 이상 지울게 없다.
        			break;
        		}
        		count++;
        	}else {						//지운 블록 개수 증가.
        		answer += temp;
        		count = 0;
        	}
        }
        
        return answer;
    }
	//검은 블록을 채우는 함수
	static void fillBlackBlock(int[][] board) {
		for(int col = 0; col < board.length; col++) {	//각 열에 대해
			int row = 0;
			if(board[row][col] != 0) {					//맨위에 블록이 있으면 검을 블록을 놓을 수 없으므로 다음 열로
				continue;
			}
			while(row + 1 < board.length && board[row + 1][col] == 0) {		//블록 위 또는 제일 아래까지 내려가서
				row++;
			}
			board[row][col] = -1;	//검은 블록을 놓는다.
		}
	}
	//블록을 지우는 함수
	static int removeBlock(int[][] board) {
		int removedBlock = 0;
		
		for(int row = 0; row < board.length; row++) {	//맵을 순회하며
			for(int col = 0; col < board.length; col++) {
				if(board[row][col] != 0) {	//빈 블록이 아닌 경우
					switch(getRectangulerType(board, row, col)) {	//지워도 되는지 블록검사 (type : 0 - 지울 수 없음, 1 - 3x2블록, 2 - 2x3블록)
					case 0:
						break;
					case 1:		//3x2블록을 지운다.
						for(int i = row; i < row + 3; i++) {
							for(int j = col; j < col + 2; j++) {
								board[i][j] = 0;
							}
						}
						for(int i = col; i < col + 2; i++) {	//위에 쌓인 검은 블록을 지운다. *이때 위에 다른 블록이 있을 수 있음에 주의
							int k = row;
							while(k - 1 >= 0 && board[k - 1][i] == -1) {
								board[--k][i] = 0;
							}
						}
						removedBlock++;
						break;
					case 2:		//2x3블록을 지운다.
						for(int i = row; i < row + 2; i++) {
							for(int j = col; j < col + 3; j++) {
								board[i][j] = 0;
							}
						}
						for(int i = col; i < col + 3; i++) {
							int k = row;
							while(k - 1 >= 0 && board[k - 1][i] == -1) {
								board[--k][i] = 0;
							}
						}
						removedBlock++;
						break;
					}
				}
			}
		}
		
		return removedBlock;
	}
	//블록 타입을 검사하는 함수
	static int getRectangulerType(int[][] block, int row, int col) {
		int type = 0;
		
		if(row + 2 < block.length && col + 1 < block.length) {	//3x2범위 검사
			int cb = 0, c = 0;
			for(int i = row; i < row + 3; i++) {
				for(int j = col; j < col + 2; j++) {
					if(block[i][j] != 0 && block[i][j] == block[row + 2][col]) {
						c++;
					}else if(block[i][j] == -1) {
						cb++;
					}
				}
			}
			if(cb == 2 && c == 4) {	//3x2내에 검은블록 2개, 같은 블록 4개가 있으면 지울 수 있다.
				type = 1;
			}
		}
		
		if(type != 1 && row + 1 < block.length && col + 2 < block.length) {		//2x3범위 검사
			int cb = 0, c = 0;
			for(int i = row; i < row + 2; i++) {
				for(int j = col; j < col + 3; j++) {
					if(block[i][j] != 0 && block[i][j] == block[row + 1][col + 1]) {
						c++;
					}else if(block[i][j] == -1) {
						cb++;
					}
				}
			}
			if(cb == 2 && c == 4) {
				type = 2;
			}
		}
		return type;
	}
}
