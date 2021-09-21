package java8;

import java.util.Scanner;

//색종이(고)
//가로, 세로 길이가 각각 100인 정사각형의 도화지가 있다.
//가로, 세로 길이가 각각 10인 검은색 종이들이 도화지에 평행하여 붙여졌을때 도화지에서 구할 수 있는 검은색 직사각형의 최대 넓이를 구하라
//직사각형은 도화지와 평행해야 한다
//직사각형은 정사각형을 포함한다.
//입력 색종이 수 N( N <= 100), 색종이 수 만큼의 색종이의 위치(x, y)
public class Jungol1124 {
	static int[][] dohwaji = new int[102][102];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, x, y, count = 0;
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					dohwaji[j][k] = 1;
				}
			}
		}

		for (int i = 1; i < dohwaji.length; i++) {
			for (int j = 1; j < dohwaji[0].length; j++) {
				if (dohwaji[i][j] == 1) {
					dohwaji[i][j] += dohwaji[i - 1][j];
				}
			}
		}
		int max = 0;
		for (int i = 1; i < dohwaji.length; i++) {
			for (int j = 1; j < dohwaji[0].length; j++) {
				int length = 100;
				int width = 1;
				for(int k = j; k >0 &&dohwaji[i][k]>0;--k, width++){
					if(dohwaji[i][k]< length){
						length =dohwaji[i][k];
						
					}
					if(max < length*width){
						max = length*width;
					}
				}
				
			}
		}/*for (int i = 1; i < dohwaji.length/2; i++) {
			for (int j = 1; j < dohwaji[0].length/2; j++) {
				System.out.print((dohwaji[i][j]<10?" "+dohwaji[i][j]:dohwaji[i][j])+ " ");
			}
			System.out.println();
		}*/
		System.out.println(max);

	}
}
