package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수 이어가기
public class BJ2635 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int max = 0, maxNum = 0;
		for(int i = 0; i <= N; i++) {
			int first = N, second = i;	//앞의 앞의 수, 앞의 수
			int count = 0;
			while(first >= second) {	//first - second가 음수가 나올때까지 반복
				int tmp = first - second;
				first = second;
				second = tmp;
				count++;
			}
			if(max < count) {	//최대 길이 갱신 및 그때의 두번째 숫자를 저장
				max = count;
				maxNum = i;
			}
		}
		
		bw.write((max + 2) + "\n");	//위의 계산에서 음수가 되는 마지막 숫자 2개를 누락하게 되므로 추가
		while(N >= maxNum) {	//두번째 숫자를 가지고 시뮬레이션
			bw.write(N + " ");
			int tmp = N - maxNum;
			N = maxNum;
			maxNum = tmp;
		}
		bw.write(N + " " + maxNum);	//마지막 숫자 2개
		
		bw.flush();
		bw.close();
		br.close();
	}
}
