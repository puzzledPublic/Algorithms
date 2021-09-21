package kakao.kakao2018;

//프렌즈 4블록
//result =  14, 15, 75, 24
public class Friends4Block {
	static int[] m = {4, 6, 5, 5};	//높이
	static int[] n = {5, 6, 15, 6};	//폭
	static String[][] board = {
		{"CCBDE", "AAADE", "AAABF", "CCBBF"},	
		{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"},
		{"AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA"},
		{"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"}
	};
	static int[][] checkMat = {{0,1}, {1,0}, {1,1}};
	
	public static void main(String[] args) {
		for(int i = 0; i < m.length; i++) {
			System.out.println(solve2(m[i],n[i],board[i]));
		}
	}
	
	static int solve2(int m, int n, String[] board) {
		
		char[][] gameBoard = new char[m][];		//게임판
		boolean[][] checkBoard = new boolean[m][n];	//지워질 위치를 저장하는 배열
		
		for(int i = 0; i < board.length; i++) {
			gameBoard[i] = board[i].toCharArray();
		}
		
		int result = 0;
		while(true) {
			//게임판을 순회하며 지워야할 위치를 checkBoard에 표시.
			for(int i = 0; i < m - 1; i++) {
				for(int j = 0; j < n - 1; j++) {
					char current = gameBoard[i][j];
					if(current != '.') {
						int sameCount = 0;
						for(int k = 0; k < 3; k++) {
							if(current != gameBoard[i + checkMat[k][0]][j + checkMat[k][1]]) {
								break;
							}
							sameCount++;
						}
						if(sameCount == 3) {
							checkBoard[i][j] = true;
							for(int k = 0; k < 3; k++) {
								checkBoard[i + checkMat[k][0]][j + checkMat[k][1]] = true;
							}
						}
					}
				}
			}
			//checkBoard를 순회하며 게임판의 캐릭터들을 지운다('.' 으로 교체)
			//이때 지워지는 개수를 계산한다.
			int count = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(checkBoard[i][j]) {
						gameBoard[i][j] = '.';
						checkBoard[i][j] = false;
						count++;
					}
				}
			}
			result += count;
			//더이상 지울게 없다면 종료.
			if(count == 0) {
				break;
			}
			//게임판을 각 열마다 마지막 행에서 처음 행까지 순회하며 캐릭터들이 떨어짐을 계산하여 게임판 갱신
			for(int i = 0; i < n; i++) {
				for(int j = m - 1; j >= 0; j--) {
					if(gameBoard[j][i] != '.' && (j + 1 < m && gameBoard[j + 1][i] == '.')) {
						int k = j;
						while(k + 1 < m && gameBoard[k + 1][i] == '.') {
							k++;
						}
						gameBoard[k][i] = gameBoard[j][i];
						gameBoard[j][i] = '.';
					}
				}
			}
		}
		return result;
	}
}
