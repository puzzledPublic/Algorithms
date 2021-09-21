package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//버블소트
//버블링하면서 모두 정렬됐을때 버블링한 횟수가 정답임을 알 수 있다. 정렬되고나서 마지막으로 확인해야하므로 +1을 해주면된다.
//매 버블마다 큰값은 맨뒤로 그외 값은 앞으로 한칸씩 앞으로 움직인다.
//앞으로 이동한 숫자들 중 가장 많이 움직인 횟수가 버블링한 횟수가 된다.
public class BJ1377 {
	static class Po {
		int v, p;
		public Po(int v, int p) {
			this.v = v;
			this.p = p;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		List<Po> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(new Po(Integer.parseInt(br.readLine()), i));	//초기 배열, 그때의 인덱스 저장
		}
		Collections.sort(list, (a, b) -> a.v - b.v);	//정렬한다.
		int max = 0;
		for(int i = 0; i < N; i++) {
			int g = list.get(i).p - i;	//초기 인덱스 - 정렬시 인덱스 = 앞으로 움직인 횟수
			if(max < g) {	//가장 큰 값.
				max = g;
			}
		}
		bw.write((max + 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
