package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//The Bucket List
//한 순간에 최대 몇개의 버킷을 사용하는지만 알면 된다.
//O(N + T) 풀이
public class BJ16770 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] startTime = new int[1001];
		int[] endTime = new int[1001];
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int bucket = Integer.parseInt(st.nextToken());
			
			//각 소마다 시작 시간과 종료 시간에 버킷 수를 저장해둔다.
			startTime[start] = bucket;
			endTime[end] = bucket;
		}	
		
		int max = 0, curr = 0;
		for(int i = 1; i <= 1000; i++) {	//1 ~ 1000 시간까지 탐색
			if(startTime[i] > 0) {	//소의 시작 시간인 경우 버킷 수 증가
				curr += startTime[i];
			}
			if(max < curr) {	//각 순간에 최대 버킷 수 갱신
				max = curr;
			}
			if(endTime[i] > 0) {	//소의 종료 시간인 경우 버킷 수 감소
				curr -= endTime[i];
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}

//O(N * T) 풀이
//public class BJ16770 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		int[] time = new int[1001];
//		for(int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int bucket = Integer.parseInt(st.nextToken());
//			
//			for(int t = start; t <= end; t++) {
//				time[t] += bucket;
//			}
//		}	
//		
//		int max = 0;
//		for(int i = 1; i <= 1000; i++) {
//			if(max < time[i]) {
//				max = time[i];
//			}
//		}
//		
//		bw.write(max + "\n");
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//}

//처음 생각한 O(n^2) 풀이
//public class BJ16770 {
//	static class Cow {
//		int start, end, bucket;
//		Cow(int start, int end, int bucket) {
//			this.start = start;
//			this.end = end;
//			this.bucket = bucket;
//		}
//	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = Integer.parseInt(br.readLine());
//		
//		List<Cow> cows = new ArrayList<>();
//		for(int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int bucket = Integer.parseInt(st.nextToken());
//			cows.add(new Cow(start, end, bucket));
//		}
//		
//		Collections.sort(cows, (a, b) -> a.start - b.start);	//시작시간 순으로 정렬
//		
//		boolean[] chk = new boolean[N];
//		int count = 0, left = 0;	//새로 사용한 버킷 수, 재사용 가능한 버킷 수
//		for(int i = 0; i < cows.size(); i++) {	//시작시간순으로 소들을 돌며
//			for(int j = i - 1; j >= 0; j--) {	//그 이전의 소들을 탐색
//				if(cows.get(i).start > cows.get(j).end && !chk[j]) {	//그 이전 소들의 먹이는 시간이 끝났고 버킷을 되돌려 받지 않았으면
//					left += cows.get(j).bucket;	//재사용 가능한 버킷으로 추가
//					chk[j] = true;	//되돌려 받았음을 표시
//				}
//			}
//			if(cows.get(i).bucket <= left) {	//재사용 가능한 버킷이 충분한 경우 
//				left -= cows.get(i).bucket;
//			}else {	//재사용 가능한 버킷이 부족한 경우 부족한건 새로 가져온다.
//				count += cows.get(i).bucket - left;
//				left = 0;
//			}
//		}
//		
//		bw.write(count + "\n");
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//}
