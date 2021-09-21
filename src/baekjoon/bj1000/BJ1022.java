package baekjoon.bj1000;

import java.util.Scanner;

//소용돌이 이쁘게 출력하기
public class BJ1022 {
	static int[] r = new int[2], c = new int[2];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < 2; i++) {
			r[i] = input.nextInt();
			c[i] = input.nextInt();
		}
		int temp = Math.max(printNumber(r[0], c[0]), printNumber(r[1], c[1]));	//자리수가 제일 높은걸 찾는다. (띄어쓰기를 위해)
		int blank = 0, result = 0;
		while(temp > 0) {
			temp /= 10;
			blank++;
		}
		for(int i = r[0]; i <= r[1]; i++) {
			for(int j = c[0]; j <= c[1]; j++) {
				result = printNumber(i, j);
				for(int k = 1; k < blank - Math.log10(result); k++) {
					System.out.print(" ");
				}
				System.out.print(result + " ");
			}
			System.out.println();
		}
	}
	static int printNumber(int x, int y) {
		int k = Math.max(Math.abs(x), Math.abs(y));	//k는 몇 바퀴째인지 나타낸다. (k * 2 + 1)^2는 k바퀴째의 마지막 숫자를 나타낸다.
		if (x == k)	//행이 일치하는 경우 [ (k, k)위치 기준 ]
	        return ((k * 2 + 1) * (k * 2 + 1) - k + y);
	    else if (y == -k)	//열이 반대편인 경우
	        return ((k * 2 + 1) * (k * 2 + 1) - 3*k + x);
	    else if (x == -k)	//행이 반대편인 경우
	        return ((k * 2 + 1) * (k * 2 + 1) - 5*k - y);
	    else	//열이 일치하는 경우
	        return ((k * 2 + 1) * (k * 2 + 1) - 7*k - x);
	}
}
