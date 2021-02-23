package ÇØ½¬¸Ê;
import java.util.*;
import java.io.*;
public class baekjoon_1302 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		for(int i = 0; i < testcase; i ++) {
			int pair = Integer.parseInt(br.readLine());
			HashMap <String, Integer> hash = new HashMap<String, Integer>();
			ArrayList <String> key = new ArrayList<String>();
			for(int j = 0; j < pair; j ++) {
				String [] temp = br.readLine().split(" ");
				if(hash.containsKey(temp[1])) {
					hash.put(temp[1], hash.get(temp[1]) + 1);
				}
				else {
					hash.put(temp[1], 1);
					key.add(temp[1]);
				}
			}
			int multiple = 1;
			for(String a : key) {
				multiple *= (hash.get(a) + 1);
			}
			
			bw.write(multiple - 1 + "\n");
		}
		bw.flush();
		bw.close();
	}
}
