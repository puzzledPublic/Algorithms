package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//랜선 자르기
public class BJ1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());	//가지고 있는 랜선 갯수, 원하는 랜선 갯수
		int[] arr = new int[K];	//가지고 있는 랜선들의 길이
		long sum = 0;	//가지고 있는 랜선들의 길이의 합
		for(int i = 0; i < K; i++) {
			sum += arr[i] = Integer.parseInt(br.readLine());
		}
		solve(arr, N, sum);
		br.close();
	}
	
	static void solve(int[] arr, int n, long sum) {	
		long after = sum / n;	//랜선들의 길이의 합을 원하는 랜선 갯수로 나누면 랜선이 하나일때 최대 길이가 된다. 이를 가지고 이분 탐색을 한다.
		long before = 1;		
		long base = (before + after) / 2;	//before <= base <= after
		while(true) {
			int flag = check(arr, base, n);	//각각의 랜선을 base로 나눠 갯수를 모두 더했을때 원하는 갯수가 맞는지 확인
			if(base == before) {	//더 이상 base를 올릴 수 없는 경우
				if(check(arr, base + 1, n) == 1) {
					System.out.println(base + 1);
				}else {
					System.out.println(base);
				}
				break;
			}
			if(flag == 1) {	//base 기준 오른쪽으로 이동
				before = base;
				base = (before + after) / 2;
			}
			else if(flag == -1) {	//base 기준 왼쪽으로 이동
				after = base;
				base = (before + after) / 2;
			}
		}
	}
	static int check(int[] arr, long base, int n) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count += arr[i] / base;
			if(count >= n) {	//나뉜 랜선 갯수가 많거나 똑같으면 base를 더 높여야 한다.	(똑같을때도 올리는 이유는 최대길이를 원하므로)
				return 1;
			}
		}
		return -1;	//랜선 갯수가 더 적으면 base를 낮춰야 한다.
	}
}
