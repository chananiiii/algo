package ť;

import java.util.*;
import java.io.*;

public class beakjoon_11866 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue <Integer> queue = new LinkedList();
		
		String [] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		for(int i = 0; i < n; i ++) {
			queue.add(i + 1);
		}
		int i = 1;
		bw.write("<");
		while(!queue.isEmpty()) {
			if(queue.size() == 1) {
				bw.write(queue.poll() + ">\n");
				break;
			}
			
			int temp = queue.poll();
			if(i < k) {
				i ++;
				queue.add(temp);
				continue;
			}
			else {
				i = 1;
				bw.write(temp + ", ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
