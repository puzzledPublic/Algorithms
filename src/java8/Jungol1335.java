package java8;

import java.util.Scanner;

//색종이 만들기, KOI 전국 2001 중등부(분할정복)
public class Jungol1335 {
	static int paper[][];
	static int wb[] = new int[2]; //wb[0] = 화이트, wb[1] = 블루
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//입력
		int N;
		N = input.nextInt();
		paper = new int[N][N];
		for(int i = 0 ; i < N; i++){
			for(int j = 0 ; j < N; j++){
				paper[i][j] = input.nextInt();
			}
		}
		
		//분할정복 
		dividePaper(0, 0, N);

		//출력
		System.out.println(wb[0] + "\n" + wb[1]);
	}
	
	static void dividePaper(int x, int y, int size){
		if(checkColor(x, y, size)){
			return;
		}
		
		size /= 2;
		
		dividePaper(x, y, size);

		dividePaper(x, y + size, size);

		dividePaper(x + size, y, size);

		dividePaper(x + size, y + size, size);
	}
	
	//하나의 색으로된 색종이인지 확인
	static boolean checkColor(int x, int y, int size){
		if(size == 1){
			wb[paper[x][y]]++;
			return true;
		}
		
		int sum = 0;
		for(int i = 0 ; i < size; i++){
			for(int j = 0; j < size; j++){
				sum += paper[x+i][y+j];
			}
		}
		
		if(sum == 0){
			wb[0]++;
			return true;
		}else if(sum == size * size){
			wb[1]++;
			return true;
		}
		return false;
	}
}
