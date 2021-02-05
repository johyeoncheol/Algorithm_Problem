/*
 * 1�ð� �� ����ϴٰ�
 * google���� �ع��� �����ϰ� ������ ������!
 * */
/* Stack�� �̿��ϸ� �ð� ���⵵�� O(n)���� �ذ� �����ϰ�
 * ���� Scanner�� �̿��ϸ� �ð� ���⵵�� Ŀ���� ������
 * BufferedReader�� ����ؾ� �Ѵٴ� ���� �˰� ��!
 * 
 * */
package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_2493 {
	public static void main(String[] args) throws Exception {
		Stack<int[]> stack = new Stack<>();
		
		//������ �����ϱ� ���ؼ� BufferedReader�� ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� �޾ƿ���
		int num = Integer.parseInt(br.readLine());
		//������ �ڿ� �ִ� ���� �޾ƿ�
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		for (int i = 1; i <= num; i++) {
			// 6 9 5 7 4 ������ �޾ƿ�
			int value = Integer.parseInt(st.nextToken());
			// 9�϶� while�� ���Ե�
			// 5�϶� ����
			// 7�϶��� ����
			while (!stack.isEmpty()) {
				//���� ���� �ִ� �� < = ���� ū�� 
				// 6>=9 X
				// 9>=5 O
				// 5>=7 X
				if (stack.peek()[1] >= value) {
					// 9�� �ִ� �ڸ��� index : 1 �̰�, 2��° �ڸ��̹Ƿ� 2 ���
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				//6�� pop
				//5�� pop
				stack.pop();
			}
			
			//stack�� ����ִ� ��� ù��° , �ι�° ��� ����
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			//1�� ������ 6 �� ����
			//2�� ������ 9�� ����
			//3�� ������ 5�� ����
			//....
			stack.push(new int[] { i, value });
		}
	}
}


//package com.Back;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Back_2493 {
//
//	static String input="5\r\n" + 
//			"6 9 5 7 4" ;
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TopNum = sc.nextInt();
//		int [] TopHigh = new int[TopNum];
//		int [] recPoint = new int[TopNum];
//		//ž�� �Է°� �ֱ�
//		for (int i = 0; i < TopNum; i++) {
//			TopHigh[i] = sc.nextInt();
//		}
//		for (int i = TopNum-1; i > 0; i--) {
//			for (int j = i-1; j >= 0; j--) {
//				if(TopHigh[j]>TopHigh[i]) {
//					recPoint[i]=j+1;
//					break;
//				}
//			}
//		}
//
//		for (int i = 0; i < TopNum; i++) {
//			System.out.print(recPoint[i]+" ");
//		}
//	}
//
//}
