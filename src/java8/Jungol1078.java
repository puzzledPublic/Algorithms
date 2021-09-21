package java8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//저글링 방사능 오염(BFS)
public class Jungol1078 {
	static class Position{
		public Position(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		int x, y, value;
	}
	static int[][] relativePos = {{-1,0},{0,-1},{1,0},{0,1}};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Queue<Position> queue = new LinkedList<Position>();
		
		int width, height, x, y;
		char[][] map;
		width = input.nextInt();
		height = input.nextInt();
		map = new char[height][width];
		for(int i = 0 ; i < height ; i++){
			String temp = input.next();
			for(int j = 0 ; j < width; j++){
				map[i][j] = temp.charAt(j);
			}
		}
		x = input.nextInt();
		y = input.nextInt();
		
		map[y-1][x-1] = 'S';
		queue.add(new Position(y-1,x-1,1));
		
		int highest = 0;
		while(!queue.isEmpty()){
			Position pos = queue.poll();
			highest = pos.value;
			for(int i = 0 ; i < relativePos.length; i++){
				if(pos.x + relativePos[i][0] >= 0 && pos.x + relativePos[i][0] < height && pos.y + relativePos[i][1] >= 0 && pos.y + relativePos[i][1] < width){
					if(map[pos.x + relativePos[i][0]][pos.y + relativePos[i][1]] == '1'){
						map[pos.x + relativePos[i][0]][pos.y + relativePos[i][1]] += pos.value;
						queue.add(new Position(pos.x + relativePos[i][0], pos.y + relativePos[i][1], pos.value + 1));
					}
				}
			}
		}
		int count = 0;
		for(int i = 0 ; i < height; i++){
			for(int j = 0 ; j < width; j++){
				if(map[i][j] == '1'){
					count++;
				}
			}
		}
		System.out.println(highest + 2);
		System.out.println(count);
	}
}

