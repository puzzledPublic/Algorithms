package kakao.kakao2018;
//추석 트래픽
public class ChuseokTraffic {
	static String[][] lines= {
		{
			"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
		},
		{
			"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"
		},
		{
			"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", 
			"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", 
			"2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", 
			"2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", 
			"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"
		 }
	};
	public static void main(String[] args) {
		for(int i = 0; i < lines.length; i++) {
			System.out.println(solve(lines[i]));
		}
	}
	//bt = 측정 기준 시간(초), nst, net = 각각 비교할 시작 시간, 종료 시간(초)
	//1. bt <= nst, net <= bt + 1 또는 
	//2. nst <= bt && net >= bt 인 경우 초당 최대 처리량 + 1
	static int solve(String[] lines) {
		double[][] times = getTimes(lines);
		int max = 0;
		for(int i = 0; i < times.length; i++) {
			double endTime = times[i][1];	//각 종료시간을 기준으로
			int count = 1;
			for(int j = 0; j < times.length; j++) {	//다른 시간과 비교
				//현재 로그 종료시간 ~ 종료시간 + 1초 안에 다른 로그의 시작시간, 종료시간이 들어가거나, 다른 로그 시작시간 ~ 종료시간에 현재 로그 종료시간이 들어가면 최대 처리량 +1
				if(i != j && ((endTime <= times[j][0] && times[j][0] < endTime + 1) || (endTime <= times[j][1] && times[j][1] < endTime + 1) || (times[j][0] <= endTime && endTime <= times[j][1]))) {
					count++;
				}
			}
			if(count > max) {
				max = count;
			}
		}
		return max;
	}
	//주어진 시간을 파싱해서 시작시간과 종료시간을 구한다(초 단위이며 밀리세컨드는 소수점 그대로 둔다.)(정수로 바꿔도 됨)
	static double[][] getTimes(String[] lines) {
		double[][] result = new double[lines.length][2];
		for(int i = 0; i < lines.length; i++) {
			String[] tmp = lines[i].split(" ");
			String[] end = tmp[1].split(":");
			result[i][1] = Integer.parseInt(end[0]) * 3600 + Integer.parseInt(end[1]) * 60 + Double.parseDouble(end[2]);
			result[i][0] = result[i][1] - Double.parseDouble(tmp[2].substring(0, tmp[2].length() - 1)) + 0.001;
		}
		return result;
	}
	
}
