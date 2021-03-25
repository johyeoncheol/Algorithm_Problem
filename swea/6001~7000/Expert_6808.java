package com.Expert;

/**
 *�Կ��̿� �ο��̴� 1���� 18������ ���� ���� 18���� ī��� ������ �ϰ� �ִ�.

�� ���� ���ӿ� ���� ī�带 �� ���� 9�徿 ī�带 ������. �׸��� ��ȩ ���忡 ���� ������ �����Ѵ�.

�� ���忡�� �� �徿 ī�带 �� ���� �� ����� �� ī�忡 ���� ���� ���ؼ� ������ ����Ѵ�.

���� ���� ���� ī�带 �� ����� �� ī�忡 ���� ���� �ո�ŭ ������ ���,

���� ���� ���� ī�带 �� ����� �ƹ��� ������ ���� �� ����.

�̷��� ��ȩ ���带 ������ ������ ������ ��, ������ �� ���� ����� �� ������ ���ڰ� �ȴ�.

�� ����� ������ ������ ���º��̴�.

�̹� ���ӿ� �Կ��̰� ���� 9���� ī�忡 ���� ���� �־�����.

�Կ��̰� ���� ī���� ������ �����ϸ�, �ο��̰� ��� ī�带 �������� ���� 9!���� ������ ����

�Կ����� ���а� ������ ���̴�.

�� ��, �Կ��̰� �̱�� ���� ���� ��찡 �� �� ���� ���� ���ϴ� ���α׷��� �ۼ��϶�.


[�Է�]

ù ��° �ٿ� �׽�Ʈ ���̽��� �� T�� �־�����.

�� �׽�Ʈ ���̽��� ù ��° �ٿ��� ��ȩ ���� ������ �������� ���еǾ� �־�����.

�� ������ 1�̻� 18�����̸�, ���� ������ ����.

�Կ��̴� ������ �־����� ������� ī�带 ���ٰ� �����ϸ� �ȴ�.


[���]

�� �׽�Ʈ ���̽����� ��#x��(x�� �׽�Ʈ���̽� ��ȣ�� �ǹ��ϸ� 1���� �����Ѵ�)�� ����ϰ� �� ĭ�� ��� ��,

�ο��̰� ī�带 ���� 9! ������ ��쿡 ���� �Կ��̰� ������ �̱�� ����� ���� ������ ���� ����� ����

���� �ϳ��� �����Ͽ� ����Ѵ�. 
[�Է�]							[���]
4
1 3 5 7 9 11 13 15 17           #1 112097 250783
18 16 14 12 10 8 6 4 2          #2 250783 112097
13 17 9 5 18 7 11 1 15          #3 336560 26320
1 6 7 9 12 13 15 17 18          #4 346656 16224
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_6808 {
	static boolean[] card;// 1-18. ��ü ī������ ������ �迭
	static boolean[] pick;// ���ÿ��� üũ �迭

	static int[] num1 = new int[9];// �Կ��̰� ���� ī�� ��ȣ ���� �迭
	static int[] num2 = new int[9];// �ο��̰� ���� ī�� ��ȣ ���� �迭
	static int win, lose;
	static int N = 9;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());// tc
		for (int tc = 1; tc <= T; tc++) {
			win = lose = 0;
			card = new boolean[19];
			pick = new boolean[N];

			st = new StringTokenizer(in.readLine().trim());// 1st TC, 9���� ī�忡 ���� ����

			int data = 0;
			// �Կ��̰� ���� ī�� �����ϱ�
			for (int i = 0; i < N; i++) {
				data = Integer.parseInt(st.nextToken());// card��ȣ
				card[data] = true;// card�迭�� �Կ��̰� ���� ī�� ��ȣ�� ĭ�� true�� ǥ��
				num1[i] = data;// �Կ��� ī��迭�� ���� ���� �ϳ��� ����
			} // �Է�

			// �ο��̰� ���� ī�� �����ϱ�. card[i]==1: �Կ��̰� ���� ī�� ��ȣ i
			data = 0;
			for (int i = 1; i < card.length; i++) {
				if (!card[i]) {// �Կ��̰� �ȹ��� ī����.�ο��̲�
					num2[data++] = i;// �ο��� ī��迭�� ���� ���� ����
				}
			} // card �迭�� �ο��̰� ���� ī�� ��ġ���� false�� ����Ǿ� ����.
			// card �迭�� �Կ��̰� ���� ī�� ��ġ���� true�� ����Ǿ� ����.
			

			perm(0, 0, 0);// �����ȣ(Ƚ��), �Կ�������, �ο��� ����
			//perm2(0, 0, 0, 0);// �����ȣ(Ƚ��), �Կ�������, �ο��� ����
			sb.append("#" + tc + " " + win + " " + lose + "\n");
		}
		System.out.println(sb.toString());
	}

	// �� ���� �� �Կ��̿� �ο��̰� ������ �ִ� ������ ���ؼ� �̱�� Ƚ���� ���� Ƚ���� ����ϴ� �޼ҵ�
	public static void perm(int round, int sum1, int sum2) {
		if(round == N) {//��� ���� ��.���� ��
			if(sum1 > sum2) win++;
			if(sum1 < sum2) lose++;
			return;
		}
		
		for (int i = 0; i < N; i++) {//�ο��� ī�带 �ٲ㺼��
			if(!pick[i]) {//i��° ī�尡 ��� x
				pick[i] = true;
				if(num1[round] > num2[i]) {
					perm(round+1, sum1 + num1[round] + num2[i], sum2);
					
				}else {
					perm(round+1, sum1, sum2 + num1[round] + num2[i]);
				}
				pick[i] = false;
			}			
		}		
	}
}


//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Expert_6808 {
//
//	static int[] Person1;
//	static int[] Person2;
//	static int win;
//	static int lose;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int TestCase = Integer.parseInt(br.readLine());
//		
//		for (int tc = 1; tc <= TestCase; tc++) {
//			StringTokenizer st= new StringTokenizer(br.readLine());
//			
//			Person1 = new int[9];
//			Person2 = new int[9];
//			
//			for (int i = 0; i < 9; i++) {
//				Person1[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			// ������������ ���Ľ����ֱ�
//			Arrays.sort(Person1);
//			 
//			int count1 =0;
//			int count2 =0;
//			//person2���� ���� �־��ֱ�
//			for (int i = 1; i <= 18; i++) {
//				if(count1<9 && Person1[count1]==i) {
//					count1++;
//					continue;
//				}else {
//					Person2[count2] = i;
//					count2++;
//				}
//			}
//			
//			for(int w :Person1) {
//				System.out.print(w+" ");
//			}
//			for(int w :Person2) {
//				System.out.print(w+" ");
//			}
//			
//			//Compare(0);
//		}
//	}
//
////	private static void Compare(int cnt) {
////		if(cnt == 9) {
////			checkWin();
////			return;
////		}
////	}
//
//}
//
//package com.Expert;
//
//import java.util.Scanner;
//
//public class Expert_6808 {
// 
//    static int T;
//    static int[] arr1;
//    static int[] arr2;
//    static int[] mix;
//    static boolean[] otherCards;
//    static boolean[] v;
//    static int win;
//    static int lose;
// 
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Scanner sc = new Scanner(System.in);
//        T = sc.nextInt();
// 
//        for (int t = 1; t <= T; t++) {
//            win = 0;
//            lose = 0;
//            otherCards = new boolean[19];
//            v = new boolean[9];
//            arr1 = new int[9];
//            arr2 = new int[9];
//            mix = new int[9];
// 
//            for (int i = 0; i < 9; i++) { // �Կ��� ī�� �ޱ�
//                arr1[i] = sc.nextInt();
//                otherCards[arr1[i]] = true;
//            }
// 
//            int count = 0;
//            for (int i = 1; i < otherCards.length; i++) { // �ο��� ī�� �ޱ�
//                if (otherCards[i] == false) {
//                    arr2[count] = i;
//                    count++;
//                }
//            }
// 
//            npr(0);
// 
//            System.out.println("#" + t + " " + win + " " + lose);
//        }
// 
//    }
// 
//    private static void npr(int cnt) {
//        // TODO Auto-generated method stub
//        if (cnt == 9) {
//            checkWin();
//            return;
//        }
// 
//        for (int i = 0; i < 9; i++) {
//            if (v[i])
//                continue;
// 
//            v[i] = true;
//            mix[cnt] = arr2[i];
//            npr(cnt + 1);
//            v[i] = false;
//        }
//    }
// 
//    private static void checkWin() {
//        // TODO Auto-generated method stub
//        int a = 0;
//        int b = 0;
// 
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] > mix[i])
//                a += arr1[i] + mix[i];
//            else
//                b += arr1[i] + mix[i];
//        }
// 
//        if (a > b)
//            win++;
//        else
//            lose++;
//    }
// 
//}