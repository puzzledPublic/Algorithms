package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Messi An-Gimossi
//분자, 분모 각각을 모두 소인수분해 한 후 나눈다.
public class BJ17355 {
	static int[] prime = new int[10000001];	//숫자가 최대 10^7이므로 10^7크기 배열 준비 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			primeFacto(d - u, true);
			primeFacto(d, false);
		}
		
		long numerator = 1, denominator = 1;	//분자, 분모
		for(int i = 2; i < 10000001; i++) {
			int count = prime[i];
			if(count > 0) {	//i의 개수가 양수라면 분자에 곱할 개수
				for(int j = 0; j < count; j++) {
					numerator = (numerator * i) % 1000000007;
				}
			}
			else if(count < 0){	//i의 개수가 음수라면 분모에 곱할 개수
				count = -count;
				for(int j = 0; j < count; j++) {
					denominator = (denominator * i) % 1000000007;
				}
			}
		}
		
		bw.write(numerator + " " + denominator + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void primeFacto(int num, boolean isNumerator) {	//num를 소인수 분해 한다.
		for(int i = 2; i * i <= num; i++) {
			while(num % i == 0) {
				num /= i;
				if(isNumerator) {	//분자라면 증가 시켜주고
					prime[i]++;
				}else {	//분모라면 감소 시켜준다.
					prime[i]--;
				}
			}
		}
		if(num > 1) {	//소수인 경우 추가.
			if(isNumerator) {
				prime[num]++;
			}else {
				prime[num]--;
			}
		}
	}
}
//Map을 사용한 첫 풀이
//public class BJ17355 {
//	static class Prime {
//		int number, count;
//		Prime(int number, int count) {
//			this.number = number;
//			this.count = count;
//		}
//	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int N = Integer.parseInt(br.readLine());
//		Map<Integer, Integer> numeratorMap = new HashMap<>();
//		Map<Integer, Integer> denominatorMap = new HashMap<>();
//		Map<Integer, List<Prime>> map = new HashMap<>();
//		
//		for(int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			int u = Integer.parseInt(st.nextToken());
//			int d = Integer.parseInt(st.nextToken());
//			u = d - u;
//			if(u > 1) {
//				List<Prime> list;
//				if(map.containsKey(u)) {
//					list = map.get(u);
//				}else {
//					list = PrimeFacto(u);
//					map.put(u, list);
//				}
//				for(Prime p : list) {
//					if(numeratorMap.containsKey(p.number)) {
//						numeratorMap.replace(p.number, numeratorMap.get(p.number) + p.count);
//					}else {
//						numeratorMap.put(p.number, p.count);
//					}
//				}
//			}
//			if(d > 1) {
//				List<Prime> list;
//				if(map.containsKey(d)) {
//					list = map.get(d);
//				}else {
//					list = PrimeFacto(d);
//					map.put(d, list);
//				}
//				for(Prime p : list) {
//					if(denominatorMap.containsKey(p.number)) {
//						denominatorMap.replace(p.number, denominatorMap.get(p.number) + p.count);
//					}else {
//						denominatorMap.put(p.number, p.count);
//					}
//				}
//			}
//		}
//		
//		
//		long numerator = 1, denominator = 1;
//		
//		for(Integer key : numeratorMap.keySet()) {
//			if(denominatorMap.containsKey(key)) {
//				int numerCount = numeratorMap.get(key);
//				int denoCount = denominatorMap.get(key);
//				numeratorMap.replace(key, numerCount - denoCount);
//				denominatorMap.replace(key, denoCount - numerCount);
//			}
//		}
//		for(Integer key : numeratorMap.keySet()) {
//			int count = numeratorMap.get(key);
//			if(count > 0) {
//				for(int i = 0; i < count; i++) {
//					numerator = (numerator * key) % 1000000007;
//				}
//			}
//		}
//		for(Integer key : denominatorMap.keySet()) {
//			int count = denominatorMap.get(key);
//			if(count > 0) {
//				for(int i = 0; i < count; i++) {
//					denominator = (denominator * key) % 1000000007;
//				}
//			}
//		}
//		
//		bw.write(numerator + " " + denominator + "\n");
//		
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	static List<Prime> PrimeFacto(int num) {
//		List<Prime> list = new ArrayList<>();
//		for(int i = 2; i * i <= num; i++) {
//			int count = 0;
//			while(num % i == 0) {
//				num /= i;
//				count++;
//			}
//			if(count > 0) {
//				list.add(new Prime(i, count));
//			}
//		}
//		if(num > 1) {
//			list.add(new Prime(num, 1));
//		}
//		return list;
//	}
//}
