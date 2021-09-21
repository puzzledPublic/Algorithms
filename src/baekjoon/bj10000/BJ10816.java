package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 카드 2 (이분탐색 말고 배열 2천만개를 만들어 탐색하는것도 통과 됨..)
public class BJ10816 {
	static class Coord {
		int s, e;
		Coord(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());	//숫자 개수
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	//이분탐색을 위한 정렬
		
		int M = Integer.parseInt(br.readLine());	//개수를 알고 싶은 숫자 개수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			int[] indexs = binarySearch(number);	//이분탐색
			bw.write((indexs[1] - indexs[0]) + " ");	//이분탐색으로 얻은 인덱스들. 두 사이의 거리가 알고 싶은 숫자의 개수이다.
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	static int[] binarySearch(int number) {
		int start = 0, end = arr.length;
		int[] result = new int[2];
		while(start < end) {	//number 이상인 숫자가 처음 나오는 위치.
			int mid = (start + end) / 2;
			if(arr[mid] >= number) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		
		result[0] = start;
		start = 0;
		end = arr.length;
		while(start < end) {	//number 이상인 숫자가 마지막에 나온 바로 뒤의 위치.
			int mid = (start + end) / 2;
			if(arr[mid] > number) {
				end = mid;
			}else {
				start = mid + 1;
			}
			
		}
		result[1] = start;
		return result;
	}
}
