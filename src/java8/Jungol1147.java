package java8;

import java.util.Arrays;
import java.util.Scanner;
//주사위 쌓기 (반복문으로 푼것, 재귀로 풀어봐야 함)
public class Jungol1147 {
	
	static int nextPos[] = {5, 3, 4, 1, 2, 0};
	static int N;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		N = input.nextInt();
		int arr[][] = new int[N][6];
		int sum[] = new int[6];
		for(int i = 0 ; i < N; i++){
			for(int j = 0 ; j < 6; j++){
				arr[i][j] = input.nextInt();
			}
		}
		for(int i = 0; i < 6; i++){
			int next = i;
			for(int j = 0 ; j < N; j++){
				if(arr[j][next] < arr[j][nextPos[next]]){
					if(arr[j][nextPos[next]] == 6 ){
						if(arr[j][next] == 5){
							sum[i] += 4;
						}
						else{
							sum[i] += 5;
						}
					}
					else{
						sum[i] += 6;
					}
				}else{
					if(arr[j][next] == 6 ){
						if(arr[j][nextPos[next]] == 5){
							sum[i] += 4;
						}else{
							sum[i] += 5;
						}
					}else{
						sum[i] += 6;
					}
				}
				
				//System.out.print(arr[j][next]+":"+arr[j][nextPos[next]]+" sum: " + sum[i]+" ");
				
				for(int k = 0; k < 6; k++){
					if(j == N-1) break;
					if(arr[j+1][k] == arr[j][nextPos[next]]){
						next = k;		
						break;
					}
				}
			}
			//System.out.println();
		}
		Arrays.sort(sum);
		System.out.println(sum[5]);
	}
}
