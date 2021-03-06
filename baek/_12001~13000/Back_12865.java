

package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bag[] b = new bag[K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			b[i] = new bag(w, v);
		}
		
		int dp[][] = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=b[i].w) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-b[i].w]+b[i].v);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
	
	static class bag{
		int w;
		int v;
		public bag(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
		
	}
}
