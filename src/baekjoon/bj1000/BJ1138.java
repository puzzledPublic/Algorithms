package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//한 줄로 서기
public class BJ1138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int k = arr[i];	// i 위치 기준 왼쪽으로 i보다 큰 수의 개수
			for(int j = 1; j <= N; j++) {
				if(k == 0 && result[j] == 0) {	//i보다 큰 수가 0개이고 빈 자리(result[j] == 0)라면 i의 위치
					result[j] = i;
					break;
				}else if(result[j] == 0) {	//i보다 큰 수가 아직 남아있고 빈자리인 경우 그곳엔 큰 수가 자리해야하므로 i보다 큰 수의 개수를 줄이고 넘어간다.
					k--;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			bw.write(result[i] + " ");
		}
		
		//스택 사용 풀이
		Stack<Integer> fStack = new Stack<>();
		Stack<Integer> bStack = new Stack<>();
		for(int i = N; i >= 1; i--) {	//거꾸로 시작
			while(fStack.size() > arr[i]) {	//왼쪽으로 i보다 큰 수 개수만큼 남도록 stack에서 제거
				bStack.add(fStack.pop());	//복구해야 하므로 다른 스택에 저장
			}
			fStack.add(i);	//i 삽입
			while(!bStack.isEmpty()) {	//제거한 수들을 복구
				fStack.add(bStack.pop());
			}
		}
		
		for(int i : fStack) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
