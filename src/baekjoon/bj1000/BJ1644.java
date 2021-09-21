package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//소수의 연속합
public class BJ1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[N + 1];
		
		for(int i = 2; i * i <= N; i++) {	//에라스토테네스의 체.
			if(!arr[i]) {
				for(int j = i + i; j <= N; j += i) {
					arr[j] = true;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 2; i <= N; i++) {	//N까지의 소수 리스트를 만든다.
			if(!arr[i]) {
				list.add(i);
			}
		}
		
		int s = 0, e = 0;	//투포인터
		int sum = 0;
		int count = 0;
		while(true) {
			if(s >= list.size() && e >= list.size()) break;	//탐색 완료시 종료.
			if(sum < N && e < list.size()) {	//s ~ (e-1)까지의 소수 합이 N보다 더 작다면 다음 소수를 더해준다.
				sum += list.get(e);
				e++;
			}else {	//소수 합이 N보다 같거나 큰 경우.
				if(sum == N) {	//같은 경우. 조건을 만족하는 경우
					count++;
				}
				sum -= list.get(s);	//맨 앞 소수(s가 가리키는 소수)를 빼준다.
				s++;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
