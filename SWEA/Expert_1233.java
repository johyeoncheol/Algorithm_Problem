package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1. ������ ������ �϶� �ڽ���
 * 	1) ������ + ������
 * 	2) ������ + ����
 * 	3) ���� + ����
 * 	4) ���� + �����ڴ� �ȵ�
 * 2. ������ �����϶� �ڽ��� �������
 * */
public class Expert_1233 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;//���� ����
		char[] tree;
		
		for (int i = 1; i < 10; i++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1]; // 1�� ��������~
			
			boolean flag = true; // ���� ��ȿ�� üũ
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken()); // ���� ��ȣ
				tree[index] = st.nextToken().charAt(0); // ������ ������ ��
			}//�Է�
			
			//��� ������ ���� ����
			int left,right;
			for (int j = 1; j <=N; j++) {
				left = j * 2;
				right = left + 1;

				// 1.������ �������� ���
				// Character.isDigit�� ���������� ���� ���!
				if (!Character.isDigit(tree[j])) { // ������
					// ���� , ������ �ڽ��� �ְ�
					if (left <= N && right <= N) {
						if (Character.isDigit(tree[left]) && Character.isDigit(tree[right])) {
							flag = false;
						}
					} else { // �ڽ��� ������
						flag = false;
					}
					// 2. ������ ������ ��� -> �ڽ��� ������ �ȵ�
				} else {
					if (left <= N) {
						flag = false;
					}
				}
				if (!flag)
					break;
			}
			System.out.println("#" + i + " " + (flag ? 1 : 0));
		}
	}
}
