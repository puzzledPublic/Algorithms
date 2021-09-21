package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//만취한 상범
public class BJ6359 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {	//테스트 케이스 횟수동안
			int N = Integer.parseInt(br.readLine());
			boolean[] room = new boolean[N + 1];	//false = 안닫힌 상태, true = 닫힌 상태
			for(int j = 2; j < N + 1; j++) {	//j = 라운드 및 배수
				for(int k = j; k < N + 1; k += j) {	//k = 문 위치 
					room[k] = !room[k];	//닫혀있음 열고 열려있음 닫는다.
				}
			}
			int count = 0;
			for(int j = 1; j < N + 1; j++) {	//열려있는 문을 센다.
				if(!room[j]) {
					count++;
				}
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
