package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이진수 변환
//문제 조건에 만족하는 수열(X)이 있고 수열에서 인접한 원소들의 차들의 집합 D(X)가 있을때
//D(X)에서 최대값과 최소값의 차이를 최소화하는 수열 X를 출력하는 문제.
//숫자 i가 있을때 연속하는 숫자들의 차이를 최소화하면 D(X)의 최대값, 최소값 차이를 최소화 할 수 있다.
//i를 2진수로 바꿨을때 맨 왼쪽 set된 bit는 그 뒤의 모든 set된 bit들을 더한 값보다 크다는 걸 알 수 있다.
//그래서 변환을 할 때 최대 맨 왼쪽 set된 bit 1개씩만 제거해 나간다면 수열 X에서 인접된 원소들의 차를 최소화 할 수 있다. 
//그리고 마지막 N번째 변환시에 나머지 set된 bit들을 바꿔주면 된다.
public class BJ17395 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long X = Long.parseLong(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int count = Long.bitCount(X);	//set된 bit 수
		if(count < N) {	//매 변환시 1개 이상의 비트를 0으로 바꿔야 하므로 set된 bit 개수 보다 변환 수가 크다면 변환 불가능 하다.
			bw.write("-1\n");
		}else {
			for(int i = 0; i < N - 1; i++) {
				long mask = 1L << 63;
				while((X & mask) == 0) {	//맨 왼쪽에 set된 bit를 제거할 mask를 만든다.
					mask >>>= 1;
				}
				X &= ~mask;	//bit 제거
				bw.write(X + " ");
			}
			
			bw.write("0");	//마지막 변환은 set된 모든 bit를 0으로 바꾸므로 그냥 0을 출력하면 된다.
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
