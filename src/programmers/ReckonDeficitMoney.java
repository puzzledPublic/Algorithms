package programmers;

//부족한 금액 계산하기
public class ReckonDeficitMoney {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price, money, count));
    }

    static long solution(int price, int money, int count) {
        long answer = 0;

        long sum = 0;
        for(int i = 1; i <= count; i++) {
            sum += (price * i);
        }

        answer = sum - money >= 0 ? sum - money : 0;

        return answer;
    }
}
