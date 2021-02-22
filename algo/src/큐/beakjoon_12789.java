package ť;

import java.util.*;
import java.io.*;

public class beakjoon_12789 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque <Integer> tempLine = new LinkedList();
		Deque <Integer> line = new LinkedList();
		int num = Integer.parseInt(br.readLine());
		int last = 1;
		String [] input = br.readLine().split(" ");
		
		for(String a : input) 
			line.addLast(Integer.parseInt(a));
		

		int lineNum = 0;
		int tempLineNum = 0;
		while(!line.isEmpty()) {
			if(last == line.peekFirst()) {
				last ++;
				line.pollFirst();
			}
			else {
				if(!tempLine.isEmpty() && last == tempLine.peekLast()) {
					tempLine.pollLast();
					last ++;
				}	
				else {
					tempLine.addLast(line.pollFirst());
				}
			}
		}
		
		while(!tempLine.isEmpty()) {
			int temp = tempLine.pollLast();
			if(temp == last)
				last ++;
			else
				break;
		}
				
		if(tempLine.isEmpty())
			bw.write("Nice\n");
		else 
			bw.write("Sad\n");
		
		bw.flush();
		bw.close();
	}
}
