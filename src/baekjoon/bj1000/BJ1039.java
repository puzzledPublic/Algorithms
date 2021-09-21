package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//교환
//일일히 숫자 두개를 바꿔서 BFS를 돌리면 중복되는 것이 많아서 시간이 오래걸릴 수 있다.
//1_000_000이므로 숫자를 서로 바꿨을때 최대 2^6개의 숫자가 나올 수 있다. 그리고 해당 숫자가 BFS에서 짝수번째로 나오면 짝수번째마다 등장한다. 홀수도 마찬가지.
//이것을 이용해 푼다.
public class BJ1039 {
	static int N, K;
	static int[] cache;	//BFS를 위한 방문 체크 배열.
	static class State {
		int number;
		int step;
		public State(int number, int step) {
			this.number = number;
			this.step = step;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		cache = new int[1000001];
		Arrays.fill(cache, -1);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N < 10 || (N < 100 && N % 10 == 0)) {	//10미만인 수, 100미만 이면서 10의 배수는 교환 불가.
			bw.write("-1\n");
		}else {
	
			int len = (int)(Math.log10(N) + 1);	//숫자 길이
			int[] arr = new int[len];	//자리 수로 나누기 위한 배열
			
			Queue<State> queue = new LinkedList<>();
			
			cache[N] = 0;	//0번 교환
			queue.add(new State(N, 0));
			while(!queue.isEmpty()) {
				State curr = queue.poll();
				
				if(curr.step >= K) {	//N번 교환했으면 종료
					break;
				}
				
				for(int i = len - 1; i >= 0; i--) {	//각 자리수로 나눈다.
					arr[i] = curr.number % 10;
					curr.number /= 10;
				}
				
				for(int i = 0; i < len - 1; i++) {	//curr.number에서 i, j를 골라 교환한다.
					for(int j = i + 1; j < len; j++) {
						
						int temp = arr[i];	//교환
						arr[i] = arr[j];
						arr[j] = temp;
						
						if(arr[0] != 0) {	//0으로 시작하지 않아야한다.
							
							int next = 0;	//자리수를 합쳐 숫자로 만듬.
							for(int k = 0; k < len; k++) {
								next += arr[k];
								next *= 10;
							}
							next /= 10;
							
							if(cache[next] == -1) {	//아직 방문 안한 숫자라면 queue에 저장
								cache[next] = curr.step + 1;
								queue.add(new State(next, curr.step + 1));
							}else {	//이미 방문한 배열이고
								if(((curr.step + 1) % 2) != (cache[next] % 2)) {	//다음 교환 횟수가 이전에 방문한 교환 횟수와 서로 짝수나 홀수가 아니고
									if((K % 2) == ((curr.step + 1) % 2)) {	//K번째와 서로 짝수거나 홀수라면
										cache[next] = curr.step + 1;	//다음 교환 횟수로 체크한다.
									}
								}//(위의 코드 설명: 해당 curr.number가 짝수번째 교환에 나타나면 짝수번째마다 등장하고 홀수번째 교환에 나타나면 홀수번째마다 등장한다.
								//만약 짝수, 홀수 둘다 등장하면 K에 맞춰 짝수 홀수로 바꿔준다.)
							}
						}
						temp = arr[i];	//교환 한 것을 되돌린다.
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			
			int max = -1;
			for(int i = 0; i <= 1000000; i++) {
				if(cache[i] != -1 && ((K % 2) == (cache[i] % 2))) {	//방문한 배열이고 K와 같은 짝수나 홀수일 경우 최대값 갱신한다.
					if(max < i) {
						max = i;
					}
				}
			}
			bw.write(max + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
