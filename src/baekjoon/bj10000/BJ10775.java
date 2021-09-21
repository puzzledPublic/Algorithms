package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//공항
public class BJ10775 {
	static int[] arr;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		arr = new int[P];
		parent = new int[G + 1];
		for(int i = 0; i < P; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= G; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		for(int i = 0; i < P; i++) {
			int root = find(arr[i]);	//현재 도착 비행기의 게이트 그룹의 루트를 찾는다.
			if(root == 0) {	//루트가 0이라면 더이상 받을 게이트가 없다. 종료.
				break;
			}
			union(root - 1, root);	//바로 전 게이트 그룹과 결합
			count++;
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int find(int u) {
		if(u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
	
	static void union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u == v) {
			return;
		}
		
		if(u < v) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		parent[u] = v;
	}
}
