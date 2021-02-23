package ÇØ½¬¸Ê;
import java.util.*;
import java.io.*;
public class baekjoon_9375 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hash = new HashMap();
		
		int max = 0;
		String key = null;
		for(int i = 0; i < num; i ++) {
			String temp = br.readLine();
			hash.put(temp, hash.containsKey(temp) ? hash.get(temp) + 1 : 1);
			int a = hash.get(temp);
			if(max < a) {
				max = a;
				key = temp;
			}
			else if (max == a) {
				if(key.compareTo(temp) >= 0) {
					key = temp;
				}
			}
		}
				
		bw.write(key + "\n");
		bw.flush();
		bw.close();
	}
}
