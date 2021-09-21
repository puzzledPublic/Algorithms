package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Sleepy Cow Herding (Bronze)
public class BJ17039 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	//소들 위치 순으로 정렬
		int between1 = arr[1] - arr[0] - 1;	//연속된 소들의 거리 계산
		int between2 = arr[2] - arr[1] - 1;
		
		if(between1 > between2) {	//between1 <= between2가 되도록한다.
			int temp = between1;
			between1 = between2;
			between2 = temp;
		}
		
		//between1이 0이면 between2에 의해 결정되고 2이상이면 최소 이동값은 2가 된다.
		//예를들어 1, 2, 3의 경우 between1 == 0, between2 == 0, 이미 모두 연속하므로 최소 이동값은 0이되고
		//1, 2, 4의 경우 between1 == 0, between2 == 1, 최소 이동값은 0
		//1, 2, 5의 경우 between1 == 0, between2 == 2, 최소 이동값은 2가 된다.
		if(between1 == 0 || between1 >= 2) {
			between1 = between2 >= 2 ? 2 : between2;
		}
		
		//최대 이동값은 두 거리 중 가장 긴 거리가 된다.
		bw.write(between1 + "\n" + between2);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
