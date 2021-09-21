package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//N으로 만들기
public class BJ17255 {
	static int N;
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String t = br.readLine();
		
		bw.write(solve(t) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(String next) {
		if(next.length() == 1) {	//길이가 1이면 1가지 경우밖에 없다.
			map.put(next, 1);
			return 1;
		}
		
		if(map.containsKey(next)) {	//Memoization
			return map.get(next);
		}
		
		map.put(next, 0);
	
		//양 옆에 숫자를 붙여 현재 상태로 오므로 이전 상태를 만들 수 있다. ex) 1234 -> 123, 234
		String nx1 = next.substring(1);	
		String nx2 = next.substring(0, next.length() - 1);
		
		if(nx1.equals(nx2)) {	//나눈것이 같은 경우 중복이므로 하나만 센다. ex) 111 -> 11 == 11
			map.replace(next, solve(nx1));
		}else {
			map.replace(next, solve(nx1) + solve(nx2));
		}
		
		return map.get(next);
	}
}
