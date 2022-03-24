package baekjoon.bj11000;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//카드
public class BJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();   //카드 숫자가 크고(Long type) 갯수는 10만개 아래이므로 맵을 사용
        for(int i = 0; i < N; i++) {
            long k = Long.parseLong(br.readLine());
            if(map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            }else {
                map.put(k, 1);
            }
        }

        int count = 0;
        Long number = Long.MAX_VALUE;
        for(Long l : map.keySet()) {
            if(count < map.get(l) || (count == map.get(l) && number > l)) {
                number = l;
                count = map.get(l);
            }
        }

        bw.write(number + "\n");

        bw.close();
        br.close();
    }
}
