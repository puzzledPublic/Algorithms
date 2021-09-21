package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주사위 네개
public class BJ2484 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), max = 0, price;
		int[] arr = new int[4];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			price = getPrice(arr);
			if(max < price) {
				max = price;
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int getPrice(int[] arr) {
		if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
			return 50000 + arr[0] * 5000;
		}else if((arr[0] == arr[1] && arr[1] == arr[2]) || (arr[0] == arr[1] && arr[1] == arr[3]) || (arr[0] == arr[2] && arr[2] == arr[3])) {
			return 10000 + arr[0] * 1000;
		}else if(arr[1] == arr[2] && arr[2] == arr[3]) {
			return 10000 + arr[1] * 1000;
		}else if((arr[0] == arr[1] && arr[2] == arr[3]) || (arr[0] == arr[2] && arr[1] == arr[3])) {
			return 2000 + arr[0] * 500 + arr[3] * 500;
		}else if(arr[0] == arr[3] && arr[1] == arr[2]) {
			return 2000 + arr[0] * 500 + arr[1] * 500;
		}else if((arr[0] == arr[1]) || (arr[0] == arr[2]) || (arr[0] == arr[3])) {
			return 1000 + arr[0] * 100;
		}else if((arr[1] == arr[2]) || (arr[1] == arr[3])) {
			return 1000 + arr[1] * 100;
		}else if(arr[2] == arr[3]) {
			return 1000 + arr[2] * 100;
		}else {
			return Math.max(arr[0], Math.max(arr[1], Math.max(arr[2], arr[3]))) * 100;
		}
	}
}
