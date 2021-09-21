package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이진트리
public class BJ13325 {
	static int[] tree;
	static int K, size;
	static long sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		size = (int)Math.pow(2, K + 1);
		tree = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 2; i < size; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			sum += tree[i];	//초기 트리의 총 가중치.
		}
		
		solve(1);
		
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long solve(int index) {	//리프 노드에서 tree[index]경로 중 최대 가중치 
		if(index * 2 >= size) {	//리프노드면 바로 리턴
			return tree[index];
		}
		
		long left= solve(index * 2);	//왼쪽 노드의 최대 가중치
		long right = solve(index * 2 + 1);	//오른쪽 노드의 최대 가중치
		//둘 중 최대 가중치에 맞춰준다. 이때 총 가중치 증가.
		if(left < right) {
			sum += (right - left);
			return right + tree[index];
		}else if(left > right) {
			sum += (left - right);
			return left + tree[index];
		}
		return left + tree[index];
	}
}
