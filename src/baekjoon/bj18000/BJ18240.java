package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//이진 탐색 트리 복원하기
public class BJ18240 {
	static class Node {
		int num;
	}
	static int[] arr;
	static boolean isValid = true;
	static int name = 1;
	static Node[] nodes;
	static List<List<Node>> list = new ArrayList<>();
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N - 1];
		nodes = new Node[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		
		nodes[0] = new Node();	//루트 노드
		list.get(0).add(nodes[0]);
		
		for(int i = 0; i < N - 1; i++) {
			int lv = arr[i];
			//현재 넣으려는 노드의 레벨이 lv일때 lv 레벨에 있는 노드의 개수는 이전 레벨(lv-1)의 노드 개수 * 2 개를 넘으면 안된다. (이진트리이므로)
			if(list.get(lv - 1).size() * 2 < list.get(lv).size() + 1) {
				isValid = false;	//이진트리 성립이 안되므로 종료
				break;
			}
			nodes[i + 1] = new Node();	//노드 삽입 순서를 저장.
			list.get(lv).add(nodes[i + 1]);	//노드들이 왼쪽으로 몰리도록 만든다.
		}
		
		namingTree(0, 0);	//중위순회로 노드들의 번호를 매긴다.
		
		if(isValid) {
			for(int i = 0; i < N; i++) {	//노드들이 삽입된 순으로 노드 번호를 출력한다.
				bw.write(nodes[i].num + " ");
			}
		}else {
			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
	
	//현 레벨(lv)에서 노드들의 위치로 중위 순회를 한다. 예를들어 0 레벨의 0번 노드는 루트 노드이고 자식 노드는 1레벨의 0번,1번 노드이다.
	static void namingTree(int lv, int index) {
		if(lv + 1 == N) {
			list.get(lv).get(index).num = name++;
			return;
		}
		
		if(list.get(lv + 1).size() > index * 2) {
			namingTree(lv + 1, index * 2);
		}
		
		list.get(lv).get(index).num = name++;
		
		if(list.get(lv + 1).size() > index * 2 + 1) {
			namingTree(lv + 1, index * 2 + 1);
		}
	}
}
