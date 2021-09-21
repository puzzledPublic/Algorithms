package java8;

import java.util.Arrays;
import java.util.Scanner;

//ȸ�ǽ� ����
//ȸ�ǽ��� �ϳ��� �ְ� ���� ȸ�ǵ��� �����Ҷ� �ִ��� ���� ȸ�ǵ��� �ϰ� �ʹ�. �ִ� ȸ�� ������ ȸ�� ��ȣ���� ����϶�
//�Է� ȸ���� �� N (5<= N <=500), n���� ȸ�� ��ȣ�� ���۽ð�, ����ð��� �־�����.
//idea: ȸ�ǽð����� ������ �ð���� �������� �����Ͽ� ������ �ð��� ���� ���� ȸ�ǵ��� �����Ͽ� ������ �ִ� ȸ�� ���� ���� �� �ִ�.
public class Jungol1370 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int[] meetOrder = new int[n];
		MeetTime[] mt = new MeetTime[n];

		for (int i = 0; i < n; i++) {
			mt[i] = new MeetTime();
		}

		for (int i = 0; i < n; i++) {
			mt[i].num = scanner.nextInt();
			mt[i].beginTime = scanner.nextInt();
			mt[i].endTime = scanner.nextInt();
		}
		//���� �̿� ����
		// Arrays.sort(mt,(a,b)->{ return Integer.compare(a.endTime,
		// b.endTime);});
		//comparable ������ ��ü�� ����
		Arrays.sort(mt);
		int earliest = 0, selected = 0;
		//��� ȸ�ǵ��� Ž��
		for (int i = 0; i < mt.length; i++) {
			//�� ȸ���� ����, ���ð�
			int meetingBegin = mt[i].beginTime;
			int meetingEnd = mt[i].endTime;
			//���� �ٷ� ���� ȸ�� �� �ð��� ���� ȸ�ǽð� ���� �۴ٸ�
			if (earliest <= meetingBegin) {
				//���� ȸ�� �� �ð��� ���� ������ �־��ְ�
				earliest = meetingEnd;
				//������ ȸ�� �迭�� �߰�
				meetOrder[selected++] = mt[i].num;
			}
		}
		System.out.println(selected);
		for (int i = 0; i < selected; i++) {
			System.out.print(meetOrder[i] + " ");
		}
	}
}

class MeetTime implements Comparable<MeetTime> {
	int num;
	int beginTime;
	int endTime;

	@Override
	public int compareTo(MeetTime o) {
		return Integer.compare(this.endTime, o.endTime);
	}
}
