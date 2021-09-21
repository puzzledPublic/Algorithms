package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//사과나무
public class BJ19539 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//물 뿌리개로 만들 수 있는 배치는 높이의 합이 3의 배수(3x)이고, 각 높이를 2로 나눈 몫의 합이 x 이상인 배치와 동치.
		int sum = 0;
		int two = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
			two += (arr[i] / 2);
		}
		
		if(sum % 3 == 0 && two >= sum / 3) {
			bw.write("YES\n");
		}else {
			bw.write("NO\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
