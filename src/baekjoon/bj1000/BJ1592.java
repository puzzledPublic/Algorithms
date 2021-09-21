package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//영식이와 친구들
public class BJ1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	//N명
		int M = Integer.parseInt(st.nextToken());	//M번 받으면 종료
		int L = Integer.parseInt(st.nextToken());	//던지는 거리 L
		
		int[] arr = new int[N + 1];	//i번째 사람이 공을 받은 횟수
		arr[1] = 1;	//1번이 시작이므로 이미 1회 받음
		
		int next = 1, count = 0;	//다음에 받는 사람, 총 던진 횟수
		while(true) {
			if(arr[next] % 2 != 0) {	//홀수인 경우 시계 방향으로
				next = (next + L) % N;
				if(next == 0) {
					next = N;
				}
			}else {		//짝수인 경우 반시계 방향으로 던진다.
				next -= L;
				if(next <= 0) {
					next = N + next;
				}
			}
			arr[next]++;	//공을 받은 횟수 증가
			count++;		//총 던진 횟수 증가
			if(arr[next] == M) {	//어느 한 사람이 M번 받았으면 종료
				break;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
