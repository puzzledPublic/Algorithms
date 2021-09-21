package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//소수경로
public class BJ1963 {
	static class PrimePath {
		int number, step;
		public PrimePath(int number, int step) {
			this.number = number;
			this.step = step;
		}
	}
	static boolean[] Prime = new boolean[10000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//에라토스테네스의 체로 1 ~ 9999까지의 소수를 구한다.
		Prime[1] = true;
		for(int i = 2; i * i <= 9999; i++) {
			if(!Prime[i]) {
				for(int j = i + i; j < 10000; j += i) {
					Prime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine()), result;
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			result = solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			bw.write(result == -1 ? "Impossible\n" : result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int start, int dest) {		//bfs
		Queue<PrimePath> queue = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		
		queue.add(new PrimePath(start, 0));
		visited[start] = true;
		int result = -1;	//도달하지 못하는 경우 -1
		
		while(!queue.isEmpty()) {
			PrimePath pp = queue.poll();	
			if(pp.number == dest) {		//원하는 비밀번호에 도달하면 종료.
				result = pp.step;
				break;
			}
			
			for(int i = 1; i <= 1000; i *= 10) {	//각 자리의 숫자를 0부터 9까지 바꿔본다.
				int temp = pp.number;	//원래 숫자
				temp -= ((temp % (i * 10)) / i) * i;	//ex) 1234 -> 1230 || 1204 || 1034 || 0234로 바꿈
				for(int j = 0; j < 10; j++) {			//0 ~ 9까지
					int next = temp + j * i;
					if(next >= 1000 && !visited[next] && !Prime[next]) { 	//만들어진 숫자가 1000 이상, 소수이며 방문한적이 없다면 탐색해 나간다.
						visited[next] = true;
						queue.add(new PrimePath(next, pp.step + 1));
					}
				}
			}
		}
		
		return result;
	}
}
