package baekjoon.bj1000;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//냅색문제
public class BJ1450 {
    static List<Long> leftList = new ArrayList<>();
    static List<Long> rightList = new ArrayList<>();
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        //물건 무게 합의 모든 경우의 수를 계산하려면 2^N만큼 들어가므로 물건을 반씩 나눠서 계산한다.(Meet in the middle)
        //물건 개수를 반으로 나눠서 각 배열의 물건 무게 합의 모든 경우의 수를 계산
        test(0, N / 2, 0, leftList);
        test(N / 2, N - (N / 2), 0, rightList);

        //leftList.sort((a, b) -> Long.compare(a, b));
        rightList.sort((a, b) -> Long.compare(a, b));   //이분탐색 할 수 있도록 정렬.

        int count = 0;
        for(Long i : leftList) {    //왼쪽 물건 무게 합
            int start = 0, end = rightList.size() - 1;
            while(start <= end) {
                int middle = (start + end) / 2;
                if(rightList.get(middle) + i <= C) {    //왼쪽 물건 무게 합과 오른쪽 물건 무게 합을 더했을때 가방 제한 무게 보다 같거나 작은 위치를 찾는다.
                    start = middle + 1;
                }else {
                    end = middle - 1;
                }
            }
            count += start; //가방 제한 무게 보다 낮은 합들의 개수 추가. (리스트가 정렬 돼 있으므로 이전 합들은 모두 가방 제한 무게 보다 낮음.)
        }

        bw.write(count + "\n");

        bw.close();
        br.close();
    }

    static void test(int c, int n, long sum, List<Long> list) {
        if(n == 0) {
            list.add(sum);
            return;
        }
        test(c + 1,n - 1, sum + arr[c], list);
        test(c + 1, n - 1, sum, list);
    }
}
