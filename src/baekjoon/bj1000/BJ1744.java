package baekjoon.bj1000;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//수 묶기
public class BJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        List<Integer> positive = new ArrayList<>(); //양수 리스트
        List<Integer> negative = new ArrayList<>(); //음수 리스트
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {  //숫자가 0인 경우 총합을 최대로 하기 위해 음수에 곱하도록 음수 리스트에 저장 
                if (num == 1) { //숫자가 1인 경우 곱하면 합이 그대로이므로 무조건 더한다.
                    sum++;
                } else {
                    positive.add(num);
                }
            } else {
                negative.add(num);
            }
        }

        positive.sort(Comparator.reverseOrder());   //내림차순 정렬
        negative.sort(Comparator.naturalOrder());   //오름차순 정렬

        //리스트에서 두개씩 짝지어 곱한 후 총합을 계산.
        for (int i = 1; i < positive.size(); i += 2) {
            sum += (positive.get(i - 1) * positive.get(i));
        }

        //숫자 갯수가 홀수개인 경우 짝짓고 남은 숫자를 더한다.
        if (positive.size() % 2 == 1) {
            sum += positive.get(positive.size() - 1);
        }

        for (int i = 1; i < negative.size(); i += 2) {
            sum += (negative.get(i - 1) * negative.get(i));
        }

        if (negative.size() % 2 == 1) {
            sum += negative.get(negative.size() - 1);
        }

        bw.write(sum + "\n");

        bw.close();
        br.close();
    }
}
