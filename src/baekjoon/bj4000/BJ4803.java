package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//트리
public class BJ4803 {
	static int[] parent = new int[501];	//parent[i] = i 정점이 속하는 그룹의 루트 정점
	static boolean[] hasCycle = new boolean[501];	//hasCycle[i] = i 정점을 루트로 하는 트리가 사이클을 이루는가?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0) {	//입력 끝
				break;
			}
			
			for(int i = 1; i < n + 1; i++) {	//초기화
				parent[i] = i;
				hasCycle[i] = false;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());	//a - b는 연결관계
				int v = find(a);	//a, b가 속한 그룹의 루트 정점을 얻는다.
				int w = find(b);
				if(v != w) {	//루트 정점이 같지 않으면 다른 그룹에 속한것이고 이를 연결해준다. //예외입력 주의(input 3 3, 1 1, 2 3, 3 1, 0 0)	그룹을 만들때 최상위 루트를 고정해줘야함.
					if(hasCycle[v]) {	//이때 v가 이미 사이클을 이루고 있다면 v 정점이 루트가 되도록 연결한다.
						union(a, b);
					}else if(hasCycle[w]) {	//그 반대로 w가 이미 사이클을 이루고 있다면 w 정점이 루트가 되도록 연결한다.
						union(b, a);
					}else {
						union(a, b);
					}
				}else {	//루트 정점이 같으면 이미 같은 그룹에 속하고 사이클이 생긴다.
					hasCycle[v] = true;	//루트 정점으로 시작하는 사이클이 존재함을 표시.
				}
			}
			
			int treeCount = 0;
			for(int i = 1; i < n + 1; i++) {
				if(parent[i] == i && !hasCycle[i]) {	//i 정점이 루트 정점이면서 사이클이 없다면 트리가 존재한다. 
					treeCount++;
				}
			}
			
			bw.write("Case " + (count++) + ": ");
			if(treeCount > 1) {
				bw.write("A forest of " + treeCount + " trees.\n");
			}else if(treeCount == 1) {
				bw.write("There is one tree.\n");
			}else {
				bw.write("No trees.\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int v) {
		if(v == parent[v]) {
			return v;
		}
		return parent[v] = find(parent[v]);
	}
	
	static void union(int v, int w) {
		v = find(v);
		w = find(w);
		
		if(v == w) {
			return;
		}
		parent[w] = v;
	}
}
