package kakao.kakao2019.intern;

import java.util.Stack;

//크레인 인형뽑기 게임
public class ClawCraneGame {
	public static void main(String[] args) {
		int[][] board = { 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 1, 0, 3 }, 
				{ 0, 2, 5, 0, 1 }, 
				{ 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 }, 
				};

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));
	}

	static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		int width = board[0].length;
		int height = board.length;
		int[] line = new int[width];
		
		for(int i = 0; i < width; i++) {	//각 열의 높이를 센다.
			int h = 0;
			for(int j = height - 1; j >= 0; j--) {
				if(board[j][i] == 0) {
					break;
				}
				h++;
			}
			line[i] = h;
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < moves.length; i++) {	//각 위치를 돌며.
			if(line[moves[i] - 1] > 0) {	//인형이 쌓여있으면.
				int doll = board[height - line[moves[i] - 1]][moves[i] - 1];	//해당 인형 타입.
				if(!stack.isEmpty() && stack.peek() == doll) {	//스택에 쌓일 인형 타입이 연속하면 제거.
					answer += 2;
					stack.pop();
				}else {	//연속하지 않으면 스택에 쌓는다.
					stack.push(doll);
				}
				line[moves[i] - 1]--;	//기계서 인형 제거
			}
		}
		
		return answer;
	}
}
