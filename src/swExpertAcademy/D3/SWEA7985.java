package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Rooted Binary Tree 재구성
public class SWEA7985 {
	static int[] arr;
	static List<List<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int size = (int)Math.pow(2, K) - 1;	//완전 트리 원소 개수
			arr = new int[size];
			list = new ArrayList<>();
			
			for(int i = 0; i < K; i++) {
				list.add(new ArrayList<>());
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0, size, 0);
			
			//출력
			bw.write("#" + t + " ");
			for(int i = 0; i < K; i++) {
				for(int num : list.get(i)) {
					bw.write(num + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int start, int end, int depth) {
		if(end - start == 1) {	//말단 노드
			list.get(depth).add(arr[start]);
			return;
		}
		int mid = (start + end) / 2;	//중앙 노드
		list.get(depth).add(arr[mid]);
		solve(start, mid, depth + 1);	//왼쪽으로 전개
		solve(mid + 1, end, depth + 1);	//오른쪽으로 전개
	}
}
