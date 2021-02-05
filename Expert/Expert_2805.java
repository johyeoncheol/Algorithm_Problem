package com.Expert;

import java.util.Scanner;

//������ Ǯ��
public class Expert_2805 {
	static int[][] map;
	static int N ,center;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc < T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			center = N / 2;
			
			//map �迭 ó��
			for (int i = 0; i < N; i++) { // ��
				char [] tmp=sc.next().toCharArray(); //�� ���� ���� �迭
				
				for (int j = 0; j < N; j++) { // ��
					//char Ÿ���� ���� '2' -> int Ÿ���� ���ڷ� �ٲٱ�
					map[i][j] = tmp[j] - '0';
					//System.out.println((int)tmp[j] + ":"+((int)'0'));
				}
			} // �Է�
			//�Է�Ȯ��
			
			System.out.println("#"+tc+" "+getHarvest());
		}
	}

	//�迭���� ���̾Ƹ�� ������ �ش��ϴ� ������ ���ؼ� ����(begin~end)
	private static int getHarvest() {
		// harvest: ����, begin: �� �࿡�� ��Ȯ�� ĭ�� ���� �ε���
		// end: ���࿡�� ��Ȯ�� ĭ�� ������ �ε���
		// gap: ���ึ�� begin, end���� ������ ����
		int harvest = 0 , begin = 0 , end = 0 , gap=0;
		
		for (int i = 0; i < N; i++) { //��
			begin = center - gap; // �߾ӿ��� �������� �̵�
			end = center + gap; // �߾ӿ��� �������� �̵�
			for (int j = begin; j <= end; j++) { // ��
				harvest += map[i][j];
			} //�־��� ���� ��Ȯ
			if(i < center) { //�߾Ӻ��� ����
				gap++;
			}else { // center ~ �Ʒ��� ��
				gap--;
			}
		}
		return 0;
	}
}


//package com.Expert;
//
//import java.util.Scanner;
//
//public class Expert_2805 {
//	static String input="1\r\n" + 
//			"5\r\n" + 
//			"14054\r\n" + 
//			"44250\r\n" + 
//			"02032\r\n" + 
//			"51204\r\n" + 
//			"52212";
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TestCase= sc.nextInt();
//		for(int tc = 1 ; tc <= TestCase;tc++) {
//			int size=sc.nextInt();
//			char [][] CharMap = new char[size][size];
//			
//			int sum=0;
//			int count=0;
//			int W=size/2;
//			for (int i = 0; i < size; i++) {
//				CharMap[i]= sc.next().toCharArray();
//			}
//			
//			for(int i=0 ; i < size; i++) {				
//				for(int j = W-count ; j<W+count+1;++j) {
//					sum+=Character.getNumericValue(CharMap[i][j]);
//				}
//				if(i<W)count++;
//				else if(i>=W)count--;
//			}
//			System.out.println("#"+tc+" "+sum);			
//		}
//	}
//
//}
