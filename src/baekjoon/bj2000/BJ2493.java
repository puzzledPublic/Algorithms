package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//탑
public class BJ2493 {
	static class Tower {
		int index, height;
		public Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		Stack<Tower> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int current = Integer.parseInt(st.nextToken());
			if(!stack.isEmpty()) {	//스택에 건물이 있으면
				if(stack.peek().height > current) {		//앞에 있는 건물이 더 크면
					bw.write(stack.peek().index + " ");	//앞의 건물에 레이저가 닿는다.
					stack.push(new Tower(i + 1, current));	//현재 건물 push
				}else {									//앞에 있는 건물이 더 작으면
					while(!stack.isEmpty() && stack.peek().height < current) {	//큰 건물이 나올때까지 pop
						stack.pop();
					}
					if(stack.isEmpty()) {	//현재 건물보다 큰 건물이 없으면
						bw.write("0 ");
					}else {					//현재 건물보다 큰 건물이 있으면
						bw.write(stack.peek().index + " ");
					}
					stack.push(new Tower(i + 1, current));
				}
			}else {		//스택에 건물이 없으면
				bw.write("0 ");
				stack.push(new Tower(i + 1, current));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
