package com.Back;

import java.util.Scanner;

public class Back17478 {
	static StringBuffer buf;
	
	public static void recursive(int num, String underBar) {
		String temp = underBar;
					
		//��� ���� ���� - Base Case			
		if(num == 0) {
			buf.append(temp + "����Լ��� ������?\n");
			buf.append(temp + "����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����.\n");
			buf.append(temp + "��� �亯�Ͽ���.\n");
			return;
		}
		
		//���-�ݺ�		
		buf.append(temp + "����Լ��� ������?\n");
		buf.append(temp + "�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		buf.append(temp + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		buf.append(temp + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\n");
			
		underBar += "____";	// ȣ��� �� ���� ������ 2���� ����.
		recursive(num-1, underBar);		
		buf.append(temp + "��� �亯�Ͽ���.\n");// ��� �� ��¹�
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		buf = new StringBuffer();
		
		buf.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		
		recursive(N, "");
		System.out.println(buf);
		scan.close();
	}

}



//package com.Back;
//
////https://www.acmicpc.net/problem/17478
//public class Back17478 {
//
//	static String answer0="��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.";
//	static String answer1="\"����Լ��� ������?\"";
//	static String answer2="\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.";
//	static String answer3="���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"";
//	static String answer4="\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"";
//	static String answer5="��� �亯�Ͽ���.";
//
//	public static void main(String[] args) {
//		System.out.println(answer0);
//		bot(2);
//	}
//	
//	static void bot(int n) {
//		if(n==0) {
//			System.out.println(answer5);
//		}
//	}
//}
