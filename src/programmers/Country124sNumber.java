package programmers;
//124나라의 숫자
public class Country124sNumber {
	public static void main(String[] args) {
		int[] n = {1, 2, 3, 4, 20};
		
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i]));
		}
	}
	
	static String solution(int n) {
	      String answer = "";
	      StringBuilder sb = new StringBuilder();
	      while(n > 0) {
	    	  int t = n / 3;
	    	  if(n % 3 == 0) {
	    		  sb.append(4);
	    		  n= t - 1;
	    	  }else {
	    		  sb.append(n % 3);
	    		  n = t;
	    	  }
	      }
	      answer = sb.reverse().toString();
	      return answer;
	  }
}
