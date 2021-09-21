package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//수 찾기
public class BJ1920 {
	//hashSet을 이용
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> s = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			if(s.contains(Integer.parseInt(st.nextToken()))) {
				bw.write(1 + "\n");
			}else {
				bw.write(0 + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//이분탐색(binary search)을 이용
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int M = Integer.parseInt(br.readLine());
//		int[] search = new int[M];
//		st = new StringTokenizer(br.readLine(), " ");
//		for(int i = 0; i < M; i++) {
//			search[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		solve(arr, search, bw);
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	
//	static void solve(int[] n, int[] M, Writer w) throws IOException {
//		Arrays.sort(n);	//이분탐색을 위한 정렬
//		int start, end;
//		for(int i = 0; i < M.length; i++) {	//알고자하는 숫자들을 순회
//			start = 0;
//			end = n.length - 1;
//			while(start <= end) {	//이분탐색
//				int mid = (start + end) / 2;
//				if(n[mid] == M[i]) {
//					w.write(1 + "\n");
//					break;
//				}else if(n[mid] > M[i]) {
//					end = mid - 1;
//				}else {
//					start = mid + 1;
//				}
//			}
//			if(start > end) {	//발견이 안됐다면 start와 end가 서로 엇갈렸을것.
//				w.write(0 + "\n");
//			}
//		}
//	}
}
