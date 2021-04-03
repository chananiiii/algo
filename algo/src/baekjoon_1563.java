import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_1563 {
	public static int N = 0;
	public static long [][][] dp = null;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		dp =  new long[1001][3][4];
		for(int i=0; i<=1000; i++) {
			for(int j=0; j<=2; j++) {
				for(int z=0; z<=3; z++) {
					dp[i][j][z] = -1;
				}
			}
		}
		
		long result = search(1, 0, 0) + search(1, 1, 0) + search(1, 0, 1); 
		System.out.println(result%1000000);
	}
	
	public static long search(int day, int late, int abs) {
		if(dp[day][late][abs] != -1) {
			return dp[day][late][abs]%1000000;
		}
		
		if(late == 2 || abs == 3) {
			dp[day][late][abs] = 0;
			return 0;
		}
		
		if(N == day) {
			dp[day][late][abs] = 1;
			return 1;
		}

		long result = 0; 
		result += (search(day+1, late+1, 0) + search(day+1, late, abs+1) + search(day+1, late, 0)) % 1000000;
		
		dp[day][late][abs] = result;
		
		return result%1000000;
	}
}
