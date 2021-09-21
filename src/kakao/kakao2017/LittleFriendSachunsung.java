package kakao.kakao2017;

//리틀 프렌즈 사천성
public class LittleFriendSachunsung {
	public static void main(String[] args) {
		int[] m = { 3, 2, 4, 2, 5 };
		int[] n = { 3, 4, 4, 2, 5 };
		String[][] board = { 
				{ 
					"DBA", 
					"C*A", 
					"CDB" 
				},
				{ 
					"NRYN", 
					"ARYA" 
				}, 
				{ 
					".ZI.", 
					"M.**", 
					"MZU.", 
					".IU." 
				},
				{ 
					"AB", 
					"BA" 
				},
				{
					"...T.",
					"HGAB.",
					"T.CB.",
					"H.GCA",
					"....."
				}
		};
		for(int i = 0; i < m.length; i++) {
			System.out.println(solution(m[i], n[i], board[i]));
		}
	}
	static class Coord {
		int x, y;
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static String solution(int m, int n, String[] board) {
		String answer = "";
		Coord[][] alphaCoord = new Coord[26][2];
		char[][] charBoard = new char[board.length][];
		for(int i = 0; i < board.length; i++) {
			charBoard[i] = board[i].toCharArray();
		}
		
		int count = 0;
		for(int i = 0; i < charBoard.length; i++) {
			for(int j = 0; j < charBoard[0].length; j++) {
				if('A' <= charBoard[i][j] && charBoard[i][j] <= 'Z') {	//해당 알파벳 쌍에 대해 좌표를 저장
					if(alphaCoord[charBoard[i][j] - 'A'][0] == null) {
						count++;
						alphaCoord[charBoard[i][j] - 'A'][0] = new Coord(i, j);
					}else {
						alphaCoord[charBoard[i][j] - 'A'][1] = new Coord(i, j);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		boolean isErased = true;
		while(true) {
			if(!isErased) {
				break;
			}
			isErased = false;
			for(int i = 0; i < alphaCoord.length; i++) {	//A -> Z로 검사
				if(alphaCoord[i][0] == null) {
					continue;
				}
				
				//type 1 = 아래 우, 아래 좌, 2 = 좌 아래, 우 아래
				if(canErase(charBoard, alphaCoord[i][0], alphaCoord[i][1], (char)('A' + i))) {	//해당 알파벳 쌍을 지울 수 있으면
					alphaCoord[i][0] = alphaCoord[i][1] = null;	//좌표를 지운다.
					sb.append((char)('A' + i));	//현재 알파벳을 순서 문자열에 추가
					count--;	//총 알파벳갯수를 감소
					isErased = true;	//하나 지워졌음을 표시
					break;	//다시 A부터 탐색 (알파벳순서로 지워야 하므로)
				}
			}
		}
		//count가 0이되어 알파벳이 모두 사라졌다면 순서 문자열, 아니라면 IMPOSSIBLE 출력
		return answer = count != 0 ? "IMPOSSIBLE" : sb.toString();
	}
	static boolean canErase(char[][] charBoard, Coord a, Coord b, char ch) {
		int height = b.x - a.x ;
		int width = b.y - a.y;
		boolean t1 = true, t2 = true;
		//아래로 검사
		for(int i = a.x + 1; i < a.x + height + 1; i++) {
			if(charBoard[i][a.y] != '.' && charBoard[i][a.y] != ch) {
				t1 = false;
				break;
			}
		}
		if(t1) {
			if(width > 0) {	//우로 검사
				for(int i = a.y + 1; i < a.y + width; i++) {
					if(charBoard[b.x][i] != '.' && charBoard[b.x][i] != ch) {
						t1 = false;
						break;
					}
				}
			}else {	//좌로 검사
				for(int i = a.y - 1; i > a.y + width; i--) {
					if(charBoard[b.x][i] != '.' && charBoard[b.x][i] != ch) {
						t1 = false;
						break;
					}
				}
			}
		}
		
		if(width > 0) {	//우로 검사
			for(int i = a.y + 1; i < a.y + width + 1; i++) {
				if(charBoard[a.x][i] != '.' && charBoard[a.x][i] != ch) {
					t2 = false;
					break;
				}
			}
		}else {	//좌로 검사
			for(int i = a.y - 1; i > a.y + width - 1; i--) {
				if(charBoard[a.x][i] != '.' && charBoard[a.x][i] != ch) {
					t2 = false;
					break;
				}
			}
		}
		//아래로 검사
		if(t2) {
			for(int i = a.x + 1; i < a.x + height + 1; i++) {
				if(charBoard[i][b.y] != '.' && charBoard[i][b.y] != ch) {
					t2 = false;
					break;
				}
			}
		}
		
		if(t1 || t2) {
			charBoard[a.x][a.y] = charBoard[b.x][b.y] = '.';
		}
		return t1 || t2;
	}
}
