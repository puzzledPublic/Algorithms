package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//탈출
public class BJ16397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		
		bw.write(solve(N, T, G) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static class Status {
		int number, tryCount;	//현재 숫자, 시도횟수
		Status(int number, int tryCount) {
			this.number = number;
			this.tryCount = tryCount;
		}
	}
	static String solve(int N, int T, int G) {
		int tryCount = -1;	//
		
		Queue<Status> queue = new LinkedList<>();
		boolean[] chk = new boolean[100000];	//이미 방문한 숫자를 체크하는 배열
		queue.add(new Status(N, 0));
		
		while(!queue.isEmpty()) {
			Status current = queue.poll();
			if(current.number == G) {			//숫자가 원하는 숫자로 변환 가능하면 리턴.
				tryCount = current.tryCount;
				break;
			}
			if(current.tryCount < T) {			//현재까지 시도 횟수가 시도 가능 횟수 이하이면
				if(current.number + 1 <= 99999 && !chk[current.number + 1]) {		//현재 숫자 + 1 하는 경우
					chk[current.number + 1] = true;
					queue.add(new Status(current.number + 1, current.tryCount + 1));
				}
				if(current.number * 2 <= 99999) {									//현재 숫자 * 2 -> 최상위숫자 -1 하는 경우
					int next = current.number * 2;
					for(int i = 10000; i >= 1; i /= 10) {
						if(next / i != 0) {
							next = (next / i - 1) * i + (next % i);
							break;
						}
					}
					if(!chk[next]) {
						chk[next] = true;
						queue.add(new Status(next, current.tryCount + 1));
					}
				}
			}
		}
		return tryCount == -1 ? "ANG" : String.valueOf(tryCount);
	}
}
