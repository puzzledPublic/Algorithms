package programmers;

import java.util.Arrays;
import java.util.Stack;

//주식가격
public class StockPrice {
	public static void main(String[] args) {
		int[] prices = {498, 501, 470, 489};
		System.out.println(Arrays.toString(solution(prices)));
	}
	static class Stock {
		int price, time;
		public Stock(int price, int time) {
			this.price = price;		//주식가격
			this.time = time;		//시작날짜
		}
	}
	static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++) {
        	int price = prices[i];
        	if(!stack.isEmpty()) {
        		while(!stack.isEmpty() && stack.peek().price > price) {		//현재 주식값 보다 큰 경우 다 빼면서 유지된 일 수 기록.
        			Stock st = stack.pop();
        			answer[st.time - 1] = i + 1 - st.time;
        		}
        		stack.push(new Stock(price, i + 1));
        	}else {
        		stack.push(new Stock(price, i + 1));
        	}
        }
        while(!stack.isEmpty()) {
			Stock st = stack.pop();
			answer[st.time - 1] = prices.length - st.time;
		}
        return answer;
    }
}
