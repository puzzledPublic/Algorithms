package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//슈퍼 마리오
public class BJ2851 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] mushroom = new int[10];
		mushroom[0] = Integer.parseInt(br.readLine());
		for(int i = 1; i < 10; i++) {	//0 ~ i의 부분합을 구해놓는다.
			mushroom[i] = mushroom[i - 1] + Integer.parseInt(br.readLine());
		}
		
		int gap = 987654321, result = 0;
		for(int i = 0; i < 10; i++) {
			int tgap = Math.abs(mushroom[i] - 100);	//100점과 차이(절대값)를 계산
			if(gap > tgap) {	//이전 값보다 100에 더 가까우면 갱신
				gap = tgap;
				result = mushroom[i];
			}else if(gap == tgap && result < mushroom[i]) {	//차이가 같고 합이 더 크다면
				result = mushroom[i];
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
