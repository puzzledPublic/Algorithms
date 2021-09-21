package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//세훈이의 선물가게
public class BJ17225 {
	static class Order {
		int time, amount;
		Order(int time, int amount) {
			this.time = time;
			this.amount = amount;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		List<Order> blueOrders = new ArrayList<>();	//각 색깔의 주문 리스트
		List<Order> redOrders = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			char color = st.nextToken().charAt(0);
			int amount = Integer.parseInt(st.nextToken());
			if(color == 'R') {
				redOrders.add(new Order(time, amount));
			}else {
				blueOrders.add(new Order(time, amount));
			}
		}
		
		List<Integer> blueTimes = new ArrayList<>();	//각 색깔로 물품의 포장을 시작하는 시간을 담는 리스트
		List<Integer> redTimes = new ArrayList<>();
		
		int currentBlueTime = 0, currentRedTime = 0;	//각 색깔의 현재 시간
		
		for(Order blueOrder : blueOrders) {
			if(currentBlueTime < blueOrder.time) {	//주문 시간이 현재 시간 보다 빠르다면 이미 주문 된 것이고 현재 시간부터 포장한다.
				currentBlueTime = blueOrder.time;
			}
			for(int i = 0; i < blueOrder.amount; i++) {
				blueTimes.add(currentBlueTime);	//각 물품당 포장 시작 시간을 저장
				currentBlueTime += A;
			}
		}
		for(Order redOrder : redOrders) {
			if(currentRedTime < redOrder.time) {
				currentRedTime = redOrder.time;
			}
			for(int i = 0; i < redOrder.amount; i++) {
				redTimes.add(currentRedTime);
				currentRedTime += B;
			}
		}
		
		List<Integer> bluePresents = new ArrayList<>();	//각 색깔의 선물 번호를 담을 리스트
		List<Integer> redPresents = new ArrayList<>();
		
		int nextPresentNumber = 1, blueIndex = 0, redIndex = 0;
		while(true) {
			if(blueIndex == blueTimes.size() && redIndex == redTimes.size()) {
				break;
			}else if(blueIndex < blueTimes.size() && redIndex == redTimes.size()) {
				for(int i = blueIndex; i < blueTimes.size(); i++) {
					bluePresents.add(nextPresentNumber++);
				}
				break;
			}else if(redIndex < redTimes.size() && blueIndex == blueTimes.size()) {
				for(int i = redIndex; i < redTimes.size(); i++) {
					redPresents.add(nextPresentNumber++);
				}
				break;
			}else {
				int blueTime = blueTimes.get(blueIndex);	//각 색깔의 포장 시작 시간을 가져와 비교
				int redTime = redTimes.get(redIndex);
				if(blueTime <= redTime) {	//시간이 같거나 파란색이 더 빠르면 물품을 먼저 가져간다
					blueIndex++;
					bluePresents.add(nextPresentNumber++);
				}else {
					redIndex++;
					redPresents.add(nextPresentNumber++);
				}
			}
		}
		
		//결과 출력
		bw.write(bluePresents.size() + "\n");
		for(int i : bluePresents) {
			bw.write(i + " ");
		}
		bw.write("\n" + redPresents.size() + "\n");
		for(int i : redPresents) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
