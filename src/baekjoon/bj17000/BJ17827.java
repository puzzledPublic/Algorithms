package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//달팽이 리스트
public class BJ17827 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[] node = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}
		
		int add = V - 1;	//사이클이 시작되는 인덱스
		for(int i = 0; i < M; i++) {
			int query = Integer.parseInt(br.readLine());
			if(query < N) {	//N보다 작으면 쿼리 그대로 출력
				bw.write(node[query] + "\n");
			}else {
				query -= add;	//add만큼 감소
				query = (query % (N - add)) + add;	//사이클 크기만큼 modular 후 add를 더하면 해당위치를 알 수 있다.
				bw.write(node[query] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
