package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

//패션왕 신해빈
public class BJ9375 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			solve(br, bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(BufferedReader r, Writer w) throws NumberFormatException, IOException {
		int n = Integer.parseInt(r.readLine());
		Map<String, Integer> map = new HashMap<>();
		String s;
		for(int i = 0; i < n; i++) {
			s = r.readLine().split(" ")[1];
			if(map.containsKey(s)) {
				map.replace(s, map.get(s) + 1);
			}else {
				map.put(s, 1);
			}
		}
		int sum = 1;
		for(String ss : map.keySet()) {	//시간초과난 코드 처럼 일일히 구하지 말고 반대로 생각해보면 (전체 경우 수 - 옷을 입지 않는 경우(1가지))를 구하면 된다.
			sum *= (map.get(ss) + 1);	//이때 전체 경우의 수를 구하는 방법은 각 옷의 종류의 옷 갯수 + 1(안 입는 경우)를 곱해주면 된다.
		}
		sum--;
		w.write(sum + "\n");
	}
	/*
	 * 시간 초과. (옷의 종류에 따라 옷 갯수를 각각 저장하고 이를 1 ~ n개까지 골라 곱한값을 다 더하면 된다고 생각)
	 * static void solve(BufferedReader r, Writer w) throws NumberFormatException, IOException {
		int n = Integer.parseInt(r.readLine());
		Map<String, Integer> map = new HashMap<>();
		String s;
		for(int i = 0; i < n; i++) {
			s = r.readLine().split(" ")[1];
			if(map.containsKey(s)) {
				map.replace(s, map.get(s) + 1);
			}else {
				map.put(s, 1);
			}
		}
		int k = map.size(), index = 0, sum = 0;
		int[] arr = new int[k];
		for(String ss : map.keySet()) {
			arr[index++] = map.get(ss);
		}
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < k; i++) {
			sum += calc(0, i + 1, k, list, arr);
		}
		System.out.println(sum);
	}
	static int calc(int n, int k, int arrLen, List<Integer> list, int[] arr) {
		if(n == k) {
			int result = 1;
			for(Integer i : list) {
				result *= arr[i];
			}
			return result;
		}
		int start = list.size() == 0 ? 0 : list.get(list.size() - 1) + 1, result = 0; 
		for(int i = start; i < arrLen; i++) {
			list.add(i);
			result += calc(n + 1, k, arrLen, list, arr);
			list.remove(list.size() - 1);
		}
		return result;
	}*/
}
