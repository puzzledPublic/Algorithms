package java8;

import java.util.Scanner;

//계단 오르기 (다이나믹) KOI 2006 초등부
public class Jungol1520 {
	static int[][] floors;
	static int[] values;
	static int N;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();		//floors[i] i번째 계단 까지 올라오는데의 최고 점수
		floors = new int[N+1][2];	//floors[i][0] -> i-1번째에서 올라오는 경우, floors[i][1] -> i-2번째에서 올라오는 경우
		values = new int[N+1];
		for(int i = 1; i < N+1; i++){
			values[i] = input.nextInt();
		}
		floors[1][0] = floors[1][1] = values[1];
		for(int i = 2; i < N+1; i++){
			floors[i][0] = floors[i-1][1] + values[i];
			floors[i][1] = Math.max(floors[i-2][0], floors[i-2][1]) + values[i];
		}
		System.out.println(Math.max(floors[N][0], floors[N][1]));
	}
	
	//FAIL!!!
	/* 
	static int[] floors;
	static int N;
	//static int count;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		floors = new int[N+1];
		for(int i = 1 ; i < N+1; i++){
			floors[i] = input.nextInt();
		}
		
		System.out.println();
		
	}
	
	
	static int step(int next, int count){
		if(next == N){
			return floors[next];
		}
		int ret = 0;
		if(next+2 > N){
			return ret += Math.max(ret, step(next+1, count+1)+floors[next]);
		}
		if(count == 2){
			return ret += Math.max(ret, step(next+2, count-1)+floors[next]);
		}
		return ret += Math.max(ret, Math.max(step(next+1, count+1)+floors[next], step(next+2, count+1)+floors[next]));
		
	}*/
}
