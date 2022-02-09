package baekjoon.bj2000;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//두 용액
public class BJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //투포인터를 위한 정렬
        Arrays.sort(arr);

        int start = 0, end = N - 1; //배열 상 왼쪽 끝, 오른쪽 끝 포인터
        int l = arr[start], r = arr[end];
        int closest = Math.abs(l + r);
        while(start < end) {
            if(closest > Math.abs(arr[start] + arr[end])) { //현재 포인터들이 가리키는 수의 합이 0에 제일 가깝다면 해당 숫자 저장
                closest = Math.abs(arr[start] + arr[end]);
                l = arr[start];
                r = arr[end];
            }

            if(arr[start] + arr[end] == 0) {    //서로 합이 0이면 바로 종료
                break;
            }

            if(arr[start] + arr[end] > 0) { //합이 양수면 오른쪽 포인터를 옮긴다.
                end--;
            }else { //합이 음수면 왼쪽 포인터를 옮긴다.
                start++;
            }
        }

        bw.write(l + " " + r);

        bw.close();
        br.close();
    }
}
