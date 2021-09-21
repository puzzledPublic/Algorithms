package java8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//토마토(고)
public class Jungol2613 {
	static class Position{
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] relativePos = { {-1,0},{0,-1},{1,0},{0,1} };
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Queue<Position> queue= new LinkedList<>();
		
		int width, height;
		int[][] tomatoBox;
		int currentTomato = 0;	//현재 날짜까지의 익은 토마토 수
		int nextTomato = 0;	//다음 날짜까지의 익은 토마토 수
		int days = 0;
		int count = 0;
		width = input.nextInt();
		height = input.nextInt();
		tomatoBox = new int[height][width];
		
		for(int i = 0 ; i < height ; i++){
			for(int j = 0; j < width ; j++){
				if((tomatoBox[i][j] = input.nextInt()) == 1){
					queue.add(new Position(i, j));
					++currentTomato;
				}
			}
		}
		
		while(!queue.isEmpty()){
			if(count == currentTomato){
				days++;
				currentTomato += nextTomato;
				nextTomato = 0;
			}
			
			Position pos = queue.poll();
			++count;
			
			for(int i = 0 ; i < relativePos.length; i++){
				if(pos.x + relativePos[i][0] >= 0 && pos.x + relativePos[i][0] < height && pos.y + relativePos[i][1] >= 0 && pos.y + relativePos[i][1] < width){
					if(tomatoBox[pos.x + relativePos[i][0]][pos.y + relativePos[i][1]] == 0){
						tomatoBox[pos.x + relativePos[i][0]][pos.y + relativePos[i][1]] = 1;
						++nextTomato;
						queue.add(new Position(pos.x + relativePos[i][0], pos.y + relativePos[i][1]));
					}
				}
			}
		}
		
		boolean flag = false;
		for(int i = 0 ; i < height ; i++){
			for(int j = 0 ; j < width ; j++){
				if(tomatoBox[i][j] == 0){
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		if(flag){
			System.out.println(-1);
		}
		else{
			System.out.println(days);
		}
	}
}
