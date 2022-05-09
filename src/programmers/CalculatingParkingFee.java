package programmers;

import java.util.*;

//주차 요금 계산
public class CalculatingParkingFee {
    public static void main(String[] args) {
        int[][] feess = {
                {180, 5000, 10, 600},   //[14600, 34400, 5000]
                {120, 0, 60, 591},  //[0, 591]
                {1, 461, 1, 10} //[14841]
        };

        String[][] recordss = {
                {
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"
                },
                {
                        "16:00 3961 IN",
                        "16:00 0202 IN",
                        "18:00 3961 OUT",
                        "18:00 0202 OUT",
                        "23:58 3961 IN"
                },
                {
                        "00:00 1234 IN"
                },
        };

        for (int i = 0; i < feess.length; i++) {
            Arrays.stream(solution(feess[i], recordss[i])).forEach((r) -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, Car> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] parsed = records[i].split(" ");
            String[] time = parsed[0].split(":");
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);    //주차장을 입차, 출차 하는 시각을 분으로 계산

            if (!map.containsKey(parsed[1])) {
                map.put(parsed[1], new Car(parsed[1]));
            }
            Car car = map.get(parsed[1]);
            if ("IN".equals(parsed[2])) {   //입차인 경우
                car.inMinute = minute;  //입차 시간 기록
                car.state = 1;  //입차 상태
            } else {    //출차인 경우
                car.accumulatedMinute += (minute - car.inMinute);   //주차 시간 누적
                car.state = 0;  //출차 상태
            }
        }


        List<Car> cars = new ArrayList<>();
        for (String key : map.keySet()) {
            Car car = map.get(key);
            if (car.state == 1) {   //아직 주차장을 나가지 않은 상태라면
                car.accumulatedMinute += (23 * 60 + 59) - car.inMinute; //입차 시간 ~ 23:59 까지 시간을 누적
            }

            car.fee = fees[1];  //기본 요금
            int exceedMinute = car.accumulatedMinute - fees[0]; //초과 시간
            if (exceedMinute >= 1) {
                if (exceedMinute % fees[2] == 0) {
                    car.fee += (exceedMinute / fees[2]) * fees[3];
                } else {    //나누었을때 정수가 아닌 경우 올림
                    car.fee += ((exceedMinute / fees[2]) + 1) * fees[3];
                }
            }
            cars.add(car);
        }
        //차량 번호 순으로 정렬
        cars.sort((a, b) -> a.num.compareTo(b.num));

        return answer = cars.stream().mapToInt(car -> car.fee).toArray();
    }

    static class Car {
        String num;
        int state, fee, accumulatedMinute, inMinute;

        Car(String num) {
            this.state = 0;
            this.num = num;
            this.fee = 0;
            this.accumulatedMinute = 0;
            this.inMinute = 0;
        }
    }
}
