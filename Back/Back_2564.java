package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2564 {
	static int[] map;
	static int N;// 상점 수
	static int H;// 가로
	static int W;// 세로

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine(), " ");

		W = Integer.parseInt(tokens.nextToken());// 가로
		H = Integer.parseInt(tokens.nextToken());// 세로

		tokens = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken()) + 1;// N: 상점 수 + 동근위치
		map = new int[H * 2 + W * 2];// 일차원 배열로 관리

		// dir: 방위(동서남북. 1은 북쪽, 2는 남쪽, 3은 서쪽, 4는 동쪽)
		// dist: 그 방향에서의 거리값
		// pos: 상점과 동근이의 위치를 1차원 배열안에 위치 시키기 위해 계산한 인덱스
		int dir = 0, dist = 0, pos = 0;

		for (int i = 1; i <= N; i++) {// 상점과 동근위치 처리
			tokens = new StringTokenizer(in.readLine(), " ");
			dir = Integer.parseInt(tokens.nextToken());
			dist = Integer.parseInt(tokens.nextToken());

			pos = getPosition(dir, dist);// 방위값과 거리의 두 가지 값을 가지고 배열안의 인덱스 계산
			map[pos] = i;// 그 위치에 상점 번호, 동근이 위치 저장
		}

		// 반복이 끝나고 나오면 동근이 위치는 pos에 저장 되어 있음(동근이가 마지막에 입력 되니까)

		int result = 0;
		for (int shop = 1; shop < N; shop++) {
			// 동근이 위치 기준으로 앞/뒤로 접근해 봄(앞:searchShop(pos, i, -1), 뒤:searchShop(pos, i, 1))
			result += Math.min(searchShop(pos, shop, -1), searchShop(pos, shop, 1));
		}

		System.out.println(result);
	}

	private static int searchShop(int pos, int shop, int move) {
		int min = 0;// 최소 움직인 거리

		while (true) {
			pos += move;// 동근이 위치에서 움직여 봄. -1인 경우 동근이 앞쪽으로 이동

			if (pos >= map.length) {
				pos = 0;

			} else if (pos < 0) {
				pos = map.length - 1;
			}

			min++;
			if (map[pos] == shop) {
				break;
			}
		}
		return min;
	}

	private static int getPosition(int dir, int dist) {
		int distance = 0;

		if (dir == 1) {// notrh
			distance = dist;

		} else if (dir == 2) {// south
			distance = W + H + (W - dist);

		} else if (dir == 3) {// west
			distance = W + H + W + (H - dist);

		} else {// east
			distance = W + dist;
		}
		return distance;
	}

}


//노가다 코드
//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
////경비원
//public class Back_2564 {
//	
//	static int x, y,ans,storeNum;
//	static ArrayList<point2> arr ;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st=new StringTokenizer(br.readLine());
//		y = Integer.parseInt(st.nextToken());
//		x = Integer.parseInt(st.nextToken());
//		
//		storeNum = Integer.parseInt(br.readLine());
//		
//		arr = new ArrayList<point2>();
//		
//		for (int i = 0; i < storeNum+1; i++) {
//			st = new StringTokenizer(br.readLine());
//			int dir = Integer.parseInt(st.nextToken());
//			int len = Integer.parseInt(st.nextToken());		
//			
//			
//			if(dir==1) {//북쪽
//				arr.add(new point2(0,len));
//			}else if (dir==2) {//남쪽
//				arr.add(new point2(x,len));
//			}else if (dir==3) {//서쪽
//				arr.add(new point2(len,0));
//			}else if (dir==4) {//동쪽
//				arr.add(new point2(len,y));
//			}
//			
//		}
//		go();
//		System.out.println(ans);
//	}
//	private static void go() {
//		
//		for(int i=0 ; i <storeNum;i++) {
//				//내 위치와 상대방 위치가 각각 북쪽 , 남쪽에 있는 경우
//			if(Math.abs(arr.get(storeNum).x - arr.get(i).x)==x) {
//				ans +=x;
//				ans +=Math.min(arr.get(storeNum).y+arr.get(i).y, 2*y-arr.get(storeNum).y-arr.get(i).y);
//				//내 위치와 상대방 위치가 각각 동쪽 , 서쪽에 있는 경우
//			}else if(Math.abs(arr.get(storeNum).y -arr.get(i).y)==y) {
//				ans +=y;
//				ans +=Math.min(arr.get(storeNum).x+arr.get(i).x, 2*x-arr.get(storeNum).x-arr.get(i).x);
//				// 그외의 위치에 있는 경우
//			}else {
//				ans+=Math.abs(arr.get(storeNum).x-arr.get(i).x);
//				ans+=Math.abs(arr.get(storeNum).y-arr.get(i).y);
//			}
//		}
//	}
//}
//
//class point2{
//	int x;
//	int y;
//	point2(int x,int y){
//		this.x = x;
//		this.y = y;
//	}
//}
