package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//터널의 입구와 출구
public class BJ5612 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int max = M, tmp = M;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	//들어간 차량 수
			int e = Integer.parseInt(st.nextToken());	//나온 차량 수
			
			int turnel = tmp + s - e;	//터널에 존재하는 차량 수
			if(turnel < 0) {	//0보다 작으면 오류. 종료
				max = 0;
				break;
			}
			if(max < turnel) {	//터널에 존재하는 최대 차량 수 갱신
				max = turnel;
			}
			tmp = turnel;	//다음 측정 값을 위해 tmp에 저장
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
