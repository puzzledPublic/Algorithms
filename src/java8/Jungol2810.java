package java8;

import java.util.Scanner;

//타일 교체 (정사각형의 타일로 바닥을 다 채우는데 최소 타일 갯수를 구하는 문제)
//(바닥의 가로 세로 길이가 주어진다 1<= 가로,세로 <=1000000)
public class Jungol2810 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int width, height;
		int length;
		long result;
		// 가로, 세로 입력
		width = scanner.nextInt();
		height = scanner.nextInt();
		//입력 체크
		if (width < 1 || width > 1000000 || height < 1 || height > 1000000) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		//타일의 한변의 길이가 바닥의 가로 세로의 최대 공약수일 때 최소의 수로 바닥을 채울 수 있다.
		//한변의 길이
		length = get_gcd(width, height);
		//타일 갯수 = 바닥 넓이 / 정사각형 넓이
		result = (long)width/length*(long)height/length;
		System.out.println(result);

		
	}
	//최대 공약수 구하는 함수 
	static int get_gcd(int a, int b){
		if(a%b==0) {
			return b;
		}
		return get_gcd(b, a%b);
	}
}
