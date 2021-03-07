package DP;

import java.util.*;
import java.io.*;

public class baekjoon_9184 {
	public static int [][][] dynamic = null;
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dynamic = new int[51][51][51];
		
		while(true) {
			String [] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			bw.write("w(" + a + ", " + b + ", " + c + ") = ");

			
			if(a < 0) {
				a = 0;
			}
			if(b < 0) { 
				b = 0;
			}
			if(c < 0) {
				c = 0;
			}
			
			bw.write(w(a, b, c) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int w(int a, int b, int c) {
		if(dynamic[a][b][c] != 0) {
			return dynamic[a][b][c];
		}
		else {
			if(a <= 0 || b <= 0 || c <= 0) {
				dynamic[a][b][c] = 1;
				return 1;
			}
			else if(a > 20 || b > 20 || c > 20) {
				dynamic[a][b][c] = w(20, 20, 20);
				return dynamic[a][b][c];
			}
			else if(a < b && b < c) {
				dynamic[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
				return dynamic[a][b][c];
			}
			else {
				dynamic[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
				return dynamic[a][b][c];
			}
		}
	}
}
