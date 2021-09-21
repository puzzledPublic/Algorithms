package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//트리의 높이와 너비
public class BJ2250 {
	static int index = 1;	//중위순회를 위한 인덱스
	static int maxDep = 1;	//트리의 최대 높이
	static int[][] nodes;	//이진트리 nodes[i][0] = i의 왼쪽노드,  nodes[i][1] = i의 오른쪽노드
	static int[] inOrder;	//inOrder[i] = 중위순서에 따라 탐색했을때 i번째 노드의 깊이 
	static int[][] minMax;	//minMax[i][0] or [i][1] = 높이가 i일때 최소, 최대
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		nodes = new int[N + 1][2];	
		boolean[] check = new boolean[N + 1];	//루트를 알기 위한 체크 배열, 루트는 들어오는 간선이 없으므로 입력에서 간선들을 모두 체크한 후 없는걸 고르면 된다.
//		minMax = new int[N + 1][2]
		inOrder = new int[N + 1];
		
		StringTokenizer st;
		int v, l, r;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			v = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			if(l != -1) {
				nodes[v][0] = l;
				check[l] = true;
			}
			if(r != -1) {
				nodes[v][1] = r;
				check[r] = true;
			}
		}
		
		solve(check, bw);
		
		bw.flush();
		bw.close();
		br.close();
	}
	//중위 순회
	static void preOrder3(int depth, int root) {
		if(nodes[root][0] == 0 && nodes[root][1] == 0) {	//현재 노드가 잎 노드라면
			if(depth > maxDep) {	//최대 깊이 갱신
				maxDep = depth;
			}
			inOrder[index++] = depth;
//			setMinMax(depth, index++);
			return;
		}
		if(nodes[root][0] != 0) {	//왼쪽노드가 있으면 탐색
			preOrder3(depth + 1, nodes[root][0]);
		}
		inOrder[index++] = depth;	//현재 노드의 깊이 저장
//		setMinMax(depth, index++);
		if(nodes[root][1] != 0) {	//오른쪽 노드가 있으면 탐색
			preOrder3(depth + 1, nodes[root][1]);
		}
	}
//	static void setMinMax(int depth, int t) {
//		if(minMax[depth][0] == 0) {
//			minMax[depth][0] = minMax[depth][1] = t;
//		}else {
//			if(minMax[depth][0] > t) {
//				minMax[depth][0] = t;
//			}
//			if(minMax[depth][1] < t) {
//				minMax[depth][1] = t;
//			}
//		}		
//	}
	static void solve(boolean[] check, Writer w) throws IOException {
		int root = 1;
		for(int i = 1; i < check.length; i++) {	//루트 노드를 탐색
			if(!check[i]) {
				root = i;
				break;
			}
		}
		
		preOrder3(1, root);
		//System.out.println(Arrays.toString(inOrder));
		
		minMax = new int[maxDep + 1][2];
		for(int i = 1; i < inOrder.length; i++) {	//중위순회를 했던 배열을 돌면서
			int cur = inOrder[i];	//i번째 노드의 높이
			if(minMax[cur][0] == 0 || minMax[cur][0] > i) {	//각 높이의 최소값 갱신
				minMax[cur][0] = i;
			}
			if(minMax[cur][1] == 0 || minMax[cur][1] < i) {	//각 높이의 최대값 갱신
				minMax[cur][1] = i;
			}
		}
		
		int width = 0, temp = 0, level = 1;	
		for(int i = maxDep; i >= 1; i--) {	//최대 높이부터 최소 높이까지
			temp = minMax[i][1] - minMax[i][0];	//너비계산
			if(width <= temp) {
				width = temp;
				level = i;
			}
		}
		w.write(level + " " + (width + 1) + "\n");
	}
}
