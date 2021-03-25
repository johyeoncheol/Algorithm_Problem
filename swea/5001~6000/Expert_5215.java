package com.Expert;

import java.util.Scanner;

public class Expert_5215 {
	static int R[][], maxCal; // R[][]: �� ��Ằ ������ Į�θ� ������ �迭
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // tc no
		
		for (int tc = 1; tc <= T; tc++) {
			// ��� ����
			int N = sc.nextInt(); //��� ����
			maxCal = sc.nextInt();//���� ����
			
			R = new int[N][2]; //[0]���� ���� ����, [1] Į�θ�
			for (int i = 0; i < N; i++) {
				R[i][0]=sc.nextInt(); // ����
				R[i][1]=sc.nextInt(); // Į�θ�
			}
			
			//�� ��Ằ ������ ����� �׶��� �������� �ְ��� �� ã��
			int idx = 0; // ������ ��� ��ȣ
			int score=0; //�� ����, ��Ḧ ������ ���� ������ �ö�
			
			int max = find(idx,score,maxCal);
			System.out.println("#"+tc+" "+max);
		}
	}

	/*idx��°�� ��Ḧ ����ؼ� (�������� �ְ� ������ �ִ�)
	 *  ������ ������� �� Į�θ� üũ �� ������ �����ϴ� �Լ�
	 *  idx : ����� ��� ��ȣ , 
	 *  score : idx ��° ��Ḧ ����������� ������,
	 *  remain : �����ִ� ��� ���� Į�θ�
	 */
	private static int find(int idx, int score, int remain) {
		
		if(remain < 0) {
			return 0;
		}
		if(remain == 0) {
			return score;
		}
		if(idx == R.length) {
			return score;
		}
		
		//idx��° ��Ḧ ������� ���� ���
		int v1 = find(idx+1,score,remain); // �� ���� ����
		
		//idx��° ��Ḧ ����� ���
		int v2 = find(idx+1,score+R[idx][0],remain - R[idx][1]);
		
		return Math.max(v1, v2);
	}


}


//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Expert_5215 {
//
//	static int MaxCal,SumCal,tc,num,Score;
//	static StringBuilder sb = new StringBuilder();
//	static int [][] material;
//	
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		
//		
//		for (tc = 0; tc < testCase; tc++) {
//			StringTokenizer line = new StringTokenizer(br.readLine());
//			
//			// ������ ��
//			num = Integer.parseInt(line.nextToken());
//			MaxCal = Integer.parseInt(line.nextToken());
//			material = new int [num][2];
//			
//			for (int i = 0; i < num; i++) {
//				StringTokenizer line2 = new StringTokenizer(br.readLine());
//				material[i][0] = Integer.parseInt(line2.nextToken());
//				material[i][1] = Integer.parseInt(line2.nextToken());
//			}
//			
//			SumCal=0;
//			Score=0;
//			
//
//		}
//			
//	}
//	
//	private static int Combi() {
//		if(SumCal>MaxCal) {
//			return Score;
//		}
//		for (int i = 0; i < num; i++) {
//			
//		}
//		return 0;
//	}
//
//}
