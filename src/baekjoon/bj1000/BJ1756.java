package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//피자 굽기
public class BJ1756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int D = Integer.parseInt(st.nextToken());	//오븐 깊이
		int N = Integer.parseInt(st.nextToken());	//피자 개수
		
		int[] oven = new int[D];	//오븐 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < oven.length; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}

		int[] pizza = new int[N];	//피자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = oven[0];
		for(int i = 0; i < oven.length; i++) {	//oven[i] = i 포함, 뒤에서 가장 작은 오븐 지름
			if(min < oven[i]) {
				oven[i] = min;
			}else {
				min = oven[i];
			}
		}
		
		int pointer = 0, position = 0;
		for(int i = oven.length - 1; i >= 0; i--) {	//오븐의 아래서부터 올라오면서 모든 피자가 순서대로 위치할 수 있는지 검사
			if(pointer == pizza.length) {
				break;
			}
			if(pizza[pointer] <= oven[i]) {
				position = i;
				pointer++;
			}
		}
		
		bw.write((pointer < pizza.length ? 0 : (position + 1)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
