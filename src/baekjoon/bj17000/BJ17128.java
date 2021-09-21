package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//소가 정보섬에 올라온 이유
public class BJ17128 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//소의 마리 수
		int Q = Integer.parseInt(st.nextToken());	//스티커 교체 수
		
		int[] cow = new int[N];
		int[] preCalc = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cow[i] = Integer.parseInt(st.nextToken());
		}
		
		int mul = cow[0] * cow[1] * cow[2] * cow[3], s = 0, e = 4;	//투포인터(s, e)
		int sum = 0;
		while(s < N) {	//A[i]*A[i+1]*A[i+2]*A[i+3]을 계산한다. (A[N]=A[1], A[N+1]=A[2], A[N+2]=A[3]이므로 e % N을 적용)
			preCalc[s] = mul;
			sum += mul;
			mul /= cow[s];
			mul *= cow[e % N];
			s++;
			e++;
		}
		//cow[i]에 해당하는 숫자의 부호가 바뀌어야하며 문제의 수식을 살펴보면 cow[i]는 preCalc[i], preCalc[i-1].. preCalc[i-3]에만 존재한다.
		//그러므로 각각 4개 preCalc 숫자의 부호를 바꿔 -2를 곱해 원래의 숫자(sum)에 더하면 된다. (기존의 숫자를 빼고 부호를 바꾼 숫자를 더해야하므로 부호를 바꾼 숫자에 -2를 곱해 더하는것과 같다.)
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < Q; i++) {
			int quest = Integer.parseInt(st.nextToken()) - 1;
			for(int j = quest; j > quest - 4; j--) {
				if(j < 0) {	//0미만인 경우, 원형이므로 마지막으로 돌아간다.
					preCalc[N + j] = -preCalc[N + j];	//부호를 바꾼다.
					sum += 2 * preCalc[N + j];	//2를 곱해 더한다.
				}else {
					preCalc[j] = - preCalc[j];
					sum += 2 * preCalc[j];
				}
			}
			bw.write(sum + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
