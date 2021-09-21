package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

//준오는 급식충이야!!
public class BJ14488 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		long T = (long)(Double.parseDouble(st.nextToken()) * 100000);	//소수를 다루지 않기 위해 정수로 바꾼다.
		
		st = new StringTokenizer(br.readLine(), " ");
		
		BigInteger[] bigInts = new BigInteger[N];	//10억 * 10억도 가능해야하므로 biginteger사용
		
		for(int i = 0; i < N; i++) {
			bigInts[i] = new BigInteger(st.nextToken() + "00000");
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		BigInteger T2 = new BigInteger(Long.toString(T));	//시간
		BigInteger mul = T2.multiply(new BigInteger(st.nextToken()));
		BigInteger left = bigInts[0].subtract(mul);	//왼쪽 끝
		BigInteger right = bigInts[0].add(mul);	//오른쪽 끝
		int meet = 1;
		for(int i = 1; i < N; i++) {
			mul = T2.multiply(new BigInteger(st.nextToken()));
			BigInteger l = bigInts[i].subtract(mul);	//현재 학생이 T초까지 왼쪽으로 이동한 위치
			BigInteger r = bigInts[i].add(mul);	//현재 학생이 T초까지 오른쪽으로 이동한 위치
			if(left.compareTo(r) == 1 || right.compareTo(l) == -1) {	//학생의 위치가 left ~ right사이를 벗어난다면 모든 학생은 한 점에 모일 수 없으므로 종료
				meet = 0;
				break;
			}
			if(left.compareTo(l) == -1) {	//left < l인경우
				left = l;
			}
			if(right.compareTo(r) == 1) {	//right > r인 경우
				right = r;
			}
		}

		bw.write(meet + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
