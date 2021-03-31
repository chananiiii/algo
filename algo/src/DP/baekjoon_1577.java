package DP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon_1577 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long [][] dp = new long[M*2+1][N*2+1];
		long [][] block = new long[M*2+1][N*2+1];
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			String [] split = br.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			int d = Integer.parseInt(split[3]);
			
			block[b+d][a+c] = 1;
		}
		
		// 가로
		for(int i=2; i<=N*2; i+=2) {
			if(block[0][i-1] == 1) {
				break;
			}
			else {
				dp[0][i] = 1;
			}
		}
		
		// 세로
		for(int i=2; i<=M*2; i+=2) {
			if(block[i-1][0] == 1) {
				break;
			}
			else {
				dp[i][0] = 1;
			}
		}
	
		for(int i=2; i<=M*2; i+=2) {
			for(int j=2; j<=N*2; j+=2) {
				if(block[i-1][j] == 0) {
					dp[i][j] += dp[i-2][j];
				}
				if(block[i][j-1] == 0) {
					dp[i][j] += dp[i][j-2];
				}
			}
		}
		
		bw.write(dp[M*2][N*2] + "\n");
		bw.flush();
		bw.close();
	}
}
