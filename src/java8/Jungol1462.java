package java8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//보물섬 (BFS)
public class Jungol1462 {
	static class Position{
		int x, y, value;
		public Position(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value =value;
		}
		
	}
	static int[][] relativePos = {{-1,0},{0,-1},{1,0},{0,1}};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Queue<Position> queue = new LinkedList<Position>();
		
		int width, height;
		height = input.nextInt();
		width = input.nextInt();
		
		char[][] originMap = new char[height][width];
		char[][] copyMap = new char[height][width];
		int longest = 0;
		String temp;
		
		for(int i = 0 ; i < height ; i++){
			temp = input.next();
			for(int j = 0 ; j < width ; j++){
				copyMap[i][j] = originMap[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0 ; i < height ; i++){
			for(int j = 0 ; j < width ; j++){
				if(originMap[i][j] != 'W'){
					copyMap[i][j] = 'D';
					queue.add(new Position(i, j, 0));
					while(!queue.isEmpty()){
						Position pos = queue.poll();
						longest = Math.max(longest, pos.value);
						for(int k = 0 ; k < relativePos.length; k++){
							if(pos.x + relativePos[k][0] >= 0 && pos.x + relativePos[k][0] < height && pos.y + relativePos[k][1] >= 0 && pos.y + relativePos[k][1] < width){
								if(copyMap[pos.x + relativePos[k][0]][pos.y + relativePos[k][1]] == 'L'){
									copyMap[pos.x + relativePos[k][0]][pos.y + relativePos[k][1]] = 'D';
									queue.add(new Position(pos.x + relativePos[k][0], pos.y + relativePos[k][1], pos.value + 1));
								}
							}
						}
					}
					for(int k = 0 ; k < height ; k++){
						for(int h = 0 ; h < width ; h++){
							copyMap[k][h] = originMap[k][h];
						}
					}
				}
			}
		}
		
		System.out.println(longest);
	}
}

