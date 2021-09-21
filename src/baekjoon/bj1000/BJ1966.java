package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//프린터 큐
public class BJ1966 {
	static class PQStruct{
		int p, w;
		public PQStruct(int p, int w) {
			this.p = p;
			this.w = w;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), new StringTokenizer(br.readLine(), " "), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int m, StringTokenizer st, Writer w) throws IOException {
		Queue<PQStruct> q = new LinkedList<>();
		int[] arr = new int[n];	//중요도를 넣을 배열
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			q.add(new PQStruct(i, arr[i]));	//큐에 그대로 넣는다.
		}
		Arrays.sort(arr);	//중요도를 정렬
		int count = 0;
		for(int i = arr.length - 1; i >= 0; i--) {	//중요도가 큰 순서부터
			while(!q.isEmpty()) {	//그 중요도가 나타날때까지 빼서 뒤에 넣는다.
				PQStruct pqs = q.peek();
				if(pqs.w == arr[i]) {	//중요도 나타나면 정지
					break;
				}
				q.poll();
				q.add(new PQStruct(pqs.p, pqs.w));
			}
			if(q.peek().p == m){	//그 중요도를 가진 노드가 우리가 원하는 노드면 종료
				break;
			}
			q.poll();	//프린팅한다.
			count++;
		}
		w.write(count + "\n");
	}
}
