package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//LCD Test
public class BJ2290 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		String n = st.nextToken();
		
		char[][] lcd = new char[s * 2 + 3][(s + 2) * n.length() + n.length()];
		int x = 0, y = 0;
		for(int i = 0; i < lcd.length; i++) {
			for(int j = 0; j < lcd[0].length; j++) {
				lcd[i][j] = ' ';
			}
		}
		for(int i = 0; i < n.length(); i++) {
			switch(n.charAt(i)) {
			case '0':
				row(lcd, x, y, s);
				column(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				column(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			case '1':
				column(lcd, x, y + s + 2 - 1, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				break;
			case '2':
				row(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1, y, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			case '3':
				row(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			case '4':
				column(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				break;
			case '5':
				row(lcd, x, y, s);
				column(lcd, x, y, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			case '6':
				row(lcd, x, y, s);
				column(lcd, x, y, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			case '7':
				row(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				break;
			case '8':
				row(lcd, x, y, s);
				column(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			case '9':
				row(lcd, x, y, s);
				column(lcd, x, y, s);
				column(lcd, x, y + s + 2 - 1, s);
				row(lcd, x + s + 2 - 1, y, s);
				column(lcd, x + s + 2 - 1,  y + s + 2 - 1, s);
				row(lcd, x + s * 2 + 2, y, s);
				break;
			}
			y += s + 2 + 1;
		}
		for(int i = 0; i < lcd.length; i++) {
			for(int j = 0; j < lcd[0].length; j++) {
				bw.write(lcd[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void column(char[][] lcd, int x, int y, int s) {
		for(int i = x + 1; i < x + s + 1; i++) {
			lcd[i][y] = '|';
		}
	}
	static void row(char[][] lcd, int x, int y, int s) {
		for(int i = y + 1; i < y + s + 1; i++) {
			lcd[x][i] = '-';
		}
	}
}
