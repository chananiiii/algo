package ť;
import java.util.*;
import java.io.*;
public class beakjoon_2164 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		Deque <Integer> deque = new ArrayDeque();
		for(int i = 0; i < num; i ++) {
			deque.addLast(i + 1);
		}
		
		while(deque.size() > 1) {
			// throw it away
			deque.pollFirst();
			// and sent it to back
			deque.addLast(deque.pollFirst());
		}
		
		bw.write(deque.pollFirst() + "\n");
		bw.flush();
		bw.close();
	}
}
