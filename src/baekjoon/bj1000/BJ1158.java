package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//조세퍼스 문제 
public class BJ1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1);	//m번 건너뛰는데 list가 0번 인덱스 부터 시작하므로 m += -1로 넘긴다.
		br.close();
	}
	
	static void solve(int n, int m) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<>();
		sb.append("<");
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		int i = 0;
		while(!list.isEmpty()) {
			i += m;
			if(i >= list.size()) {
				i %= list.size();
			}
			if(list.size() == 1) {
				sb.append(list.remove(i) + ">");
			}else {
				sb.append(list.remove(i) + ", ");
			}
		}
		System.out.println(sb);
	}
}
