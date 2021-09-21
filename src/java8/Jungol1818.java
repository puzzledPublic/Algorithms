package java8;

import java.util.Scanner;

//바이러스  dfs or bfs 문제..
public class Jungol1818 {
	static boolean connection[][];
	static boolean isInfected[];
	static int count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N, connectionCount, x, y;
		N = input.nextInt();
		connectionCount = input.nextInt();
		
		isInfected = new boolean[N+1];
		connection = new boolean[N+1][N+1];
		
		//isInfected[1] = true;
		
		
		for(int i = 0 ; i < connectionCount; i++){
			x = input.nextInt();
			y = input.nextInt();
			connection[x][y] = true;
			connection[y][x] = true;
			
		}
		//dfs시작
		check(1);
		
		/*for(int i = 2; i < isInfected.length; i++){
			if(isInfected[i] == true){
				//System.out.print(i+" ");
				count++;
			}
		}*/
		System.out.println(count);
	}
	static void check(int x){
		
		isInfected[x] = true;
		
		for(int i = 1; i < connection.length; i++){
			if(connection[x][i]){
				if(!isInfected[i]){
					//System.out.println(i +" ! ");
					count++;
					check(i);
				}
			}
		}
	
	}
}
