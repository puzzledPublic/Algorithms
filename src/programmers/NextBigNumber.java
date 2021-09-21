package programmers;
//다음 큰 숫자
public class NextBigNumber {
	public static void main(String[] args) {
		int[] n = {78, 15};
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i]));
		}
	}
	
	static int solution(int n) {
	      int answer = 0;
	      int index = 1;
	      int count = 0;
	      int x = 1, mask = -1;
	      boolean flag = false;
	      for(int i = 0; i < 31; i++) {
	    	  if((n & index) > 0) {		//비트 1이 나타나면 센다.
	    		  count++;
	    		  flag = true;
	    	  }
	    	  if(flag && (n & index) == 0) {	//비트1이 나타난 후 0이 나타나는 순간 종료
	    		  for(int j = 0; j < i; j++) {	//거기까지 마스크를 만든다.
	    			  x <<= 1;
	    			  mask <<= 1;
	    		  }
	    		  break;
	    	  }
	    	  index <<= 1;
	      }
	      n &= mask;	//마스크를 씌위 i번째 이하의 비트를 0으로 만듬.
	      n |= x;		
	      
	      x = -1;
	      for(int i = 0; i < count - 1; i++) {	//나머지 채워야할 비트
	    	  x <<= 1;
	      }
	      n |= ~x;
	      return answer = n;
	}
}
