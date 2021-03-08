package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * */
class Point{
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Expert_1247 {

	

	static Point home;
	static Point company;
	static Point[] customers;
	static int N, ans;
	// np�� ���� �迭, �湮�ؾ� �Ǵ� �� ����
	static int[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TestCase; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // ����
			customers = new Point[N]; // �� ���� ����
			selected = new int[N]; // �� �湮 �迭 ����

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			company = new Point(x,y);
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home= new Point(x,y);
			
			for(int i = 0 ; i < N ; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				customers[i] = new Point(x,y);
			}
			
			//np ����ϱ� ���� �迭 �غ� 0,1,2,3,4,.... N-1
			for (int i = 0; i < N; i++) {
				selected[i] = i;
			}
			
			//������ ���� ���� üũ
			do {
				int tmp = calc(selected);
				ans = ans> tmp ? tmp:ans;
			} while (np(selected));
			System.out.println("#");
		}
	}

	private static boolean np(int[] selected) {
		//1. i ã��(top), i-1��°�� ��ȯ ���
		int i = N - 1;
		while(i>0 && selected[i-1]>=selected[i]) {
			i--;
		}
		//������ ������ ���
		if(i==0)
			return false;
	
		//2. j ã��
		int j = N-1;
		while(selected[i-1] >= selected[j]) {
			j--;
		}
		//3. i-1 ~ j�� ���� swap
		swap(selected,i-1,j);
		
		//4. i(top)~�ǳ�(N-1)���� �������� �����ؼ� ���� ���� �� ����
		int k = N-1;
		while(i<k) {
			swap(selected,i++,k--);
		}
		
		return false;
	}

	// selected �迭�� �ִ� ����� ���� �湮�ؼ� �Ÿ� ����� ��
	private static int calc(int[] selected) { //012345 , 31245
		int sum = 0;
		//1. ȸ��~ ù��
		sum+= getDistance(company,customers[0]);
		
		//2. N���� �� �湮
		int i = 0;
		for (i = 0; i < selected.length-1; i++) {
			int from = selected[i]; //����
			int to = selected[i+1]; //����
			
			sum+=getDistance(customers[from],customers[to]);
		}
		
		//3. ������ �� ~ ��
		sum+= getDistance(customers[selected[i]],home);
		return sum;
	}
	private static int getDistance(Point from, Point to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y-to.y);
	}

	private static void swap(int[] selected,int i, int j) {
		int tmp = selected[i];
		selected[i] = selected[j];
		selected[j] = tmp;
	}
}
