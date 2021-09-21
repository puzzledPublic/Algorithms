package java8;

import java.util.Scanner;
//문자 마름모
public class Jungol1331 {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		if(m >100 || m < 1){
			System.exit(0);
		}
		char[][] ch = new char[m * 2 - 1][m * 2 - 1];
		char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		int k = 0;
		int n = m - 1;
		int x = 0;
		int y = m - 1;
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				ch[i][j] = ' ';
			}
		}
		while (n > 0) {
			for (int i = 0; i < n; i++) {
				ch[x++][y--] = alphabet[k % 26];
				k++;
			}
			for (int i = 0; i < n; i++) {
				ch[x++][y++] = alphabet[k % 26];
				k++;
			}
			for (int i = 0; i < n; i++) {
				ch[x--][y++] = alphabet[k % 26];
				k++;
			}
			for (int i = 0; i < n; i++) {
				ch[x--][y--] = alphabet[k % 26];
				k++;
			}

			x++;
			n--;
		}
		ch[m - 1][m - 1] = alphabet[k % 26];

		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[i].length; j++) {
				System.out.print(ch[i][j] + " ");
			}
			System.out.println();
		}
	}
}
