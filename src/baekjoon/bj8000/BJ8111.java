package baekjoon.bj8000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//0과 1
//0과 1로 이루어진 최대 100자리 숫자의 모든 경우를 탐색하면 2^100이므로 시간 초과다.
//나눗셈을 생각해보면 N으로 숫자를 나눌때 각 단계에서 0~N-1까지의 나머지가 발생한다.
//이 나머지의 마지막에 0 또는 1을 붙이고 이를 또 다시 N으로 나누는 과정을 반복하면 N으로 나누어 떨어지는 경우가 있는데 이로써 0, 1로된 숫자를 만들 수 있다.
//나누다보면 동일한 나머지가 반복될 수 있는데 이 경우는 사이클 생기므로 나뉘어 떨어지지 않는다.
public class BJ8111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] chk = new int[N + 1];	//방문 체크 배열이면서 복원 경로를 위한 배열.
			char[] zo = new char[N + 1];	//'0', '1'복원을 위한 배열
			
			int last = -1;
			Queue<Integer> queue = new LinkedList<>();
			chk[0] = chk[1] = 1;
			zo[1] = '1';
			queue.add(1);	//1로 시작해야한다.
			while(!queue.isEmpty()) {
				int i = queue.poll();
				
				int ended0 = i * 10;	//맨 뒤 0을 붙인 숫자
				int ended1 = (i * 10) + 1;	//맨 뒤 1을 붙인 숫자.
				
				if(ended0 % N == 0) {	//N으로 나뉘어 떨어지면 종료.
					last = ended0 % N;
					chk[ended0 % N] = i;
					zo[ended0 % N] = '0';
					break;
				}else if(chk[ended0 % N] == 0) {
					chk[ended0 % N] = i;
					zo[ended0 % N] = '0';
					queue.add(ended0 % N);	//0 이나 1을 붙인 숫자를 계속 저장하면 길이가 늘어나므로 나머지만 저장.
				}
				
				if(ended1 % N == 0) {	//N으로 나뉘어 떨어지면 종료.
					last = ended1 % N;
					chk[ended1 % N] = i;
					zo[ended1 % N] = '1';
					break;
				}else if(chk[ended1 % N] == 0) {
					chk[ended1 % N] = i;
					zo[ended1 % N] = '1';
					queue.add(ended1 % N);
				}
								
			}
			
			if(last >= 0) {	//거꾸로 추적한다.
				StringBuilder sb = new StringBuilder();
				while(last != 1) {
					sb.append(zo[last]);
					last = chk[last];
				}
				sb.append("1");
				bw.write(sb.reverse().toString() + "\n");
			}else {
				bw.write("BRAK\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
