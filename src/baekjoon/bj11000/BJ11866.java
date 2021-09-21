package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//조세퍼스 문제 0 (1 <= m <= n <= 1000)
public class BJ11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		solve(N, M, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int m, Writer w) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		int c = 1;
		w.write("<");
		while(!q.isEmpty()) {
			if(c == m) {	//n번 건너 뛰면 출력
				if(q.size() == 1) {
					w.write(q.poll() + "");
				}else {
					w.write(q.poll() + ", ");
				}
				c = 1;
			}else {	//n번 건너뛰기 (큐에 빼서 다시 넣는다)
				Integer i = q.poll();
				q.add(i);
				c++;
			}
		}
		w.write(">");
	}
	//위 방법말고 while { index += m, if(m >= list.size) { index %= list.size }, list.remove(index) , print }할 수도 있다.
	//BJ1158 문제 참조(1<= m <= n <= 5000)
}
