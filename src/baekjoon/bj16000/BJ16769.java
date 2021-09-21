package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Mixing Milk
public class BJ16769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] capacity = new int[3];	//버킷 용량
		int[] milks = new int[3];	//우유 용량
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			capacity[i] = Integer.parseInt(st.nextToken());
			milks[i] = Integer.parseInt(st.nextToken());
		}
		
		int pours = 0, curr = 0;
		while(pours < 100) {	//100번을 붓는다
			int next = (curr + 1) % 3;
			if(capacity[next] < milks[next] + milks[curr]) {	//curr -> next에 우유를 붓는데 next 버킷의 capacity를 넘어가는 경우
				milks[curr] -= (capacity[next] - milks[next]);
				milks[next] = capacity[next];
			}else {	//아닌 경우
				milks[next] += milks[curr];
				milks[curr] = 0;
			}
			
			curr = next;
			pours++;
		}
		
		for(int i = 0; i < 3; i++) {
			bw.write(milks[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
