package java8;

import java.util.Scanner;

//스도쿠 KOI 2006 초등부/중등부
//백트래킹 필요 
public class Jungol1824 {
	public static void main(String[] args) {
		
	}
}
//Time Limit Exceed한 풀이 (4개만 통과 됨)
/*
public class Jungol1824 {
	static int[][] arr = new int[9][9];
	static int[] numbers = new int[10];
	static int pos;
	static int zeroCount;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j <arr.length; j++){
				if((arr[i][j] = input.nextInt()) == 0){
					zeroCount++;
				}
			}
		}
		
		while(zeroCount!=0){
			checkWidth();
			checkHeight();
			checkBox();
		}
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void checkWidth(){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				numbers[arr[i][j]]++;
				if(arr[i][j] == 0){
					pos = j;
				}
			}
			if(numbers[0] == 1){
				for(int j = 1; j < numbers.length; j++){
					if(numbers[j] == 0){
						arr[i][pos] = j;
						zeroCount--;
						break;
					}
				}
			}
			init();
		}
	}
	static void checkHeight(){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				numbers[arr[j][i]]++;
				if(arr[j][i] == 0){
					pos = j;
				}
			}
			if(numbers[0] == 1){
				for(int j = 1; j < numbers.length; j++){
					if(numbers[j] == 0){
						arr[pos][i] = j;
						zeroCount--;
						break;
					}
				}
			}
			init();
		}
	}
	static void checkBox(){
		int posx = 0,posy = 0;
		for(int i = 0 ; i < arr.length; i+=3){
			for(int j = 0; j <arr.length; j+=3){
				for(int k = i ; k < i+3; k++){
					for(int p = j ; p < j+3; p++){
						numbers[arr[k][p]]++;
						if(arr[k][p] == 0){
							posx = k;
							posy = p;
						}
					}
				}
				if(numbers[0] == 1){
					for(int u = 1; u < numbers.length; u++){
						if(numbers[u] == 0){
							arr[posx][posy] = u;
							zeroCount--;
							break;
						}
					}
				}
				init();
			}
		}
	}
	static void init(){
		for(int i = 0 ; i < numbers.length; i++){
			numbers[i] = 0;
		}
	}
}*/
