package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Hawk eyes
public class BJ13698 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] mixOrder = br.readLine().toCharArray();
		char[] cups = {'S', ' ', ' ', 'B'};
		for(char ch : mixOrder) {	//섞는 순서에 따라 시뮬레이션
			switch(ch) {
			case 'A':
				swap(cups, 0, 1);
				break;
			case 'B':
				swap(cups, 0, 2);
				break;
			case 'C':
				swap(cups, 0, 3);
				break;
			case 'D':
				swap(cups, 1, 2);
				break;
			case 'E':
				swap(cups, 1, 3);
				break;
			case 'F':
				swap(cups, 2, 3);
				break;
			}
		}
		
		//공들의 위치
		int s = 0, b = 0;
		for(int i = 0; i < 4; i++) {
			if(cups[i] == 'S') {
				s = i + 1;
			}else if(cups[i] == 'B') {
				b = i + 1;
			}
		}
		
		bw.write(s + "\n" + b + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void swap(char[] cups, int i, int j) {
		char temp = cups[i];
		cups[i] = cups[j];
		cups[j] = temp;
	}
}
