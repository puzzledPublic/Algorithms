package programmers;

import java.util.Arrays;

//숫자의 표현
public class NumberExpression {
	public static void main(String[] args) {
		int n = 15;
		
		System.out.println(solution(n));
	}
	
	static int solution(int n) {
	      int answer = 0;
	      
	      int[] arr = new int[n + 1];
	      for(int i = 1; i < arr.length; i++) {
	    	  arr[i] = arr[i - 1] + i;
	      }
	      
	      for(int i = 0; i <= n; i++) {
	    	  for(int j = i; j <= n; j++) {
	    		  if(arr[j] - arr[i] == n) {
	    			  answer++;
	    		  }
	    		  if(arr[j] - arr[i] > n) {	//n이상되면 다음은 필요 없으므로 종료
	    			  break;
	    		  }
	    	  }
	      }
	      return answer;
	}
	
	//어떤 자연수를 연속된 자연수의 합으로 나타내는 방법의 수는 해당 자연수의 홀수 약수의 개수와 같다
	//f(x)를 x개의 연속된 항의 합으로 가정하자.
	//먼저 x개의 항을 나열해보면
	//x == 2일때 n-1, n						f(2) = 2n-1	(n>=2)
	//x == 3일때 n-1, n, n+1					f(3) = 3n	(n>=2)
	//x == 4일떄 n-2, n-1, n, n+1				f(4) = 2(2n-1)	(n>=3)
	//x == 5일때 n-2, n-1, n, n+1, n+2		f(5) = 5n		(n>=3)
	//x == 6일때 n-3, n-2, n-1, n, n+1, n+2 	f(6) = 3(2n-1)	(n>=4)
	//즉 x = 2k일때 f(x) = k(2n-1) (n>=k+1)
	//  x = 2k-1일때 f(x) = (2k-1)n (n>=k)이다.
	//그러므로 어떤 자연수 t를 자연수의 합으로 표현 여부는
	//t가 k의 배수인지, 2k-1의 배수인지알고 그때 n의 범위가 만족하는지 알면된다. 만족한다면 만족하는 x, x개의 연속 자연수들로 나타낼 수 있음을 말한다.
	
	static int solution2(int n) {
		int answer = 0;
		for(int i = 1; i <= n; i += 2) {
			if(n % i == 0) {
				answer++;
			}
		}
		return answer;
	}
}
