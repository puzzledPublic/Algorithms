package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//스위치 켜고 끄기
public class BJ1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] swt = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			swt[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(sex == 1) {	//남학생인 경우
				for(int j = 1; j <= N / num; j++) {	//num의 배수들의 스위치 반전
					swt[num * j] = 1 - swt[num * j];
				}
			}else {	//여학생인 경우
				swt[num] = 1 - swt[num];	//해당 스위치 반전
				int s = 1;
				while((num - s > 0 && num + s <= N) && (swt[num - s] == swt[num + s])) {	//하나씩 늘려가며 좌우 대칭인 동안 스위치 반전
					swt[num - s] = swt[num + s] = 1 - swt[num - s];
					s++;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {	//20개씩 끊어 출력
			bw.write(swt[i] + " ");
			if(i % 20 == 0) {
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
