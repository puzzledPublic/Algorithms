package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//돌려막기
public class BJ17207 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] names = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
		
		int[][] mat1 = new int[5][5];
		int[][] mat2 = new int[5][5];
		
		for(int i = 0; i < 5; i++) {	//첫번째 matrix 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				mat1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 5; i++) {	//두번째 matrix 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				mat2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int min = Integer.MAX_VALUE, index = 0;
		for(int i = 0; i < 5; i++) {	//matrix 곱
			int sum = 0;
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					sum += mat1[i][k] * mat2[k][j];
				}
			}
			if(min >= sum) {	//최소값을 찾는다.
				min = sum;
				index = i;
			}
		}
		
		bw.write(names[index] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
