package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//풍선 맞추기
public class BJ11509 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int[] arr = new int[1000002];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(arr[in + 1] == 0) {	//현재 높이 + 1 인 풍선이 화살에 의해 터지지 않았으면
				arr[in]++;	//현재 풍선을 화살로 쏜다.
				count++;	//화살 개수 증가
			}else {	//현재 높이 + 1인 풍선이 화살에 의해 터졌으면
				arr[in + 1]--;	//현재 높이 + 1인 풍선이 터진것을 되돌린다.
				arr[in]++;	//현재 풍선은 화살에 의해 터진다.
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
