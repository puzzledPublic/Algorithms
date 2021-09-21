package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game2048 {
	static int N;
	static int[][] gameBoard;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		gameBoard = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				gameBoard[i][j] = input.nextInt();
			}
		}
		int result = 2;
		for(int i = 0; i < 4; i++) {
			result = Math.max(result, solve(0, i, gameBoard));
		}
		System.out.println(result);
	}
	
	static int solve(int count, int direction, int[][] state) {
		if(count == 5) {
			return  maximunNumber(state);
		}
		int result = 2;
		int[][] newState = new int[N][N];
		
		Queue<Integer> queue = new LinkedList<>();
		if(direction == 0) {	//위
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(state[j][i] != 0) {
						queue.add(state[j][i]);
					}
				}
				int index = 0, current;
				while(!queue.isEmpty()) {
					current = queue.poll();
					if(queue.peek() != null && current == queue.peek()) {
						newState[index++][i] = current * 2;	
						queue.poll();
					} else {
						newState[index++][i] = current;
					}
				}
			}
		} else if(direction == 1) {	//아래
			for(int i = 0; i < N; i++) {
				for(int j = N - 1; j >= 0; j--) {
					if(state[j][i] != 0) {
						queue.add(state[j][i]);
					}
				}
				int index = N - 1, current;
				while(!queue.isEmpty()) {
					current = queue.poll();
					if(queue.peek() != null && current == queue.peek()) {
						newState[index--][i] = current * 2;	
						queue.poll();
					} else {
						newState[index--][i] = current;
					}
				}
			}
		} else if(direction == 2) {	//왼쪽
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(state[i][j] != 0) {
						queue.add(state[i][j]);
					}
				}
				int index = 0, current;
				while(!queue.isEmpty()) {
					current = queue.poll();
					if(queue.peek() != null && current == queue.peek()) {
						newState[i][index++] = current * 2;	
						queue.poll();
					} else {
						newState[i][index++] = current;
					}
				}
			}
		} else {	//오른쪽
			for(int i = 0; i < N; i++) {
				for(int j = N - 1; j >= 0; j--) {
					if(state[i][j] != 0) {
						queue.add(state[i][j]);
					}
				}
				int index = N - 1, current;
				while(!queue.isEmpty()) {
					current = queue.poll();
					if(queue.peek() != null && current == queue.peek()) {
						newState[i][index--] = current * 2;	
						queue.poll();
					} else {
						newState[i][index--] = current;
					}
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			result = Math.max(result, solve(count + 1, i, newState));
		}
		return result;
	}
	static int maximunNumber(int[][] state) {
		int result = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result = Math.max(result, state[i][j]);
			}
		}
		return result;
	}
}
