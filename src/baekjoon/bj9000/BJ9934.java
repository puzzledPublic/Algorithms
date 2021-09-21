package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//완전 이진 트리
public class BJ9934 {
	static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = 1;
		for(int i = 0 ; i < K; i++) {
			size *= 2;
		}
		size--;
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < K; i++) {
			list.add(new ArrayList<>());
		}
		solve(0, arr.length, (arr.length - 1) / 2, 0, arr);
		for(List<Integer> l : list) {
			for(int i = 0; i < l.size(); i++) {
				if(i == l.size() - 1) {
					bw.write(l.get(i) + "");
				}else {
					bw.write(l.get(i) + " ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int start, int end, int root, int level, int[] arr) throws IOException {
		if(start == end) {
			return;
		}
		list.get(level).add(arr[root]);
		int mid = (start + end) / 2;
		solve(start, mid, (start + mid) / 2, level + 1, arr);
		solve(mid + 1, end, (mid + end + 1) / 2, level + 1, arr);
	}
}
