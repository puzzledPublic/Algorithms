package algorithmsForPS;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//주어진 정수의 자리수를 바꿀때 가능한 소수들을 출력하라.(자신도 포함)
public class AfcPrimeNumber {
	
	static int[] nums;
	static boolean[] visited;
	static Set<Integer> possibles;
	static int positionAmount;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		positionAmount = (int)Math.log10(number) + 1;
		nums = new int[positionAmount];
		visited = new boolean[positionAmount];
		possibles = new TreeSet<>();
		
		solve(number);
	}
	
	static void solve(int number) {
		//숫자 분리
		detach(number);	
		//순열 생성
		permutate(0);
		//정렬
		Integer[] sorted = sort(possibles);
		//소수 구분
		for(Integer i : sorted) {
			if(isPrimeNumber(i)) {
				System.out.print(i + " ");
			}
		}
	}
	static boolean isPrimeNumber(int number) {
		for(int i = 2; i * i <= number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static Integer[] sort(Set<Integer> set) {
		return set.stream().sorted().toArray(Integer[]::new);
	}
	
	static void permutate(int k) {
		if(k == positionAmount) {
			possibles.add(Integer.parseInt(sb.toString()));
		}
		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sb.append(nums[i]);
				permutate(k + 1);
				sb.deleteCharAt(sb.length() - 1);
				visited[i] = false;
			}
		}
	}
	static void detach(int number) {
		for(int i = 0; i < positionAmount; i++) {
			nums[i] = number % 10;
			number = number / 10;
		}
	}
	
}
